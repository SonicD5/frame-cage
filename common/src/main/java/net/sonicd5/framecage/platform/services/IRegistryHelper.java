package net.sonicd5.framecage.platform.services;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface IRegistryHelper {

    <I extends Item> Supplier<I> item(
            String path,
            Function<Item.Properties, I> itemFunc,
            Item.Properties properties
    );

    default <I extends Item> Supplier<I> item(
            String path,
            Function<Item.Properties, I> itemFunc
    ) {
        return item(path, itemFunc, new Item.Properties());
    }

    @SuppressWarnings("unchecked")
    default <I extends Item> Supplier<I> item(
            String path,
            Item.Properties properties
    ) {
        return item(path, props -> (I) new Item(props), properties);
    }

    default <I extends Item> Supplier<I> item(String path) {
        return item(path, new Item.Properties());
    }

    Supplier<SoundEvent> soundEvent(String path);

    <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            BlockBehaviour.Properties blockProps,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    );

    default <B extends Block> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            BlockBehaviour.Properties blockProps,
            boolean hasBlockItem
    ) {
        return block(
                path, blockFunc, blockProps,
                hasBlockItem ? BlockItem::new : null, new Item.Properties()
        );
    }

    @SuppressWarnings("unchecked")
    default <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            BlockBehaviour.Properties blockProps,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    ) {
        return block(path, props -> (B) new Block(props), blockProps, itemBiFunc, itemProps);
    }

    default <B extends Block> Supplier<B> block(
            String path,
            BlockBehaviour.Properties blockProps,
            boolean hasBlockItem
    ) {
        return block(path, blockProps, hasBlockItem ? BlockItem::new : null, new Item.Properties());
    }

    default <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    ) {
        return block(path, blockFunc, BlockBehaviour.Properties.of(), itemBiFunc, itemProps);
    }

    default <B extends Block> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            boolean hasBlockItem
    ) {
        return block(path, blockFunc, hasBlockItem ? BlockItem::new : null, new Item.Properties());
    }

    default <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    ) {
        return block(path, BlockBehaviour.Properties.of(), itemBiFunc, itemProps);
    }

    default <B extends Block> Supplier<B> block(
            String path,
            boolean hasBlockItem
    ) {
        return block(path, hasBlockItem ? BlockItem::new : null, new Item.Properties());
    }


    <E extends EntityType<T>, T extends Entity> Supplier<E> entityType(
            String path,
            EntityType.Builder<T> builder
    );

    <G extends CreativeModeTab> Supplier<G> creativeModeTab(
            String path,
            UnaryOperator<CreativeModeTab.Builder> builderFunc
    );

}
