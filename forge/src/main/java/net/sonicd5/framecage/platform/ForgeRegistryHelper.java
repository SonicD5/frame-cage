package net.sonicd5.framecage.platform;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.FrameCageForge;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ForgeRegistryHelper implements IRegistryHelper {

    @Override
    public <I extends Item> Supplier<I> item(
            String path, Function<Item.Properties, I> itemFunc, Item.Properties properties
    ) {
        return FrameCageForge.ITEMS.register(path,
                () -> itemFunc.apply(properties.setId(
                ResourceKey.create(Registries.ITEM, FrameCage.id(path))))
        );
    }

    @Override
    public Supplier<SoundEvent> soundEvent(String path) {
        return FrameCageForge.SOUND_EVENTS.register(
                path, () -> SoundEvent.createVariableRangeEvent(FrameCage.id(path))
        );
    }

    @Override
    public <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            BlockBehaviour.Properties blockProps,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    ) {

        var block = FrameCageForge.BLOCKS.register(path,
                () -> blockFunc.apply(
                blockProps.setId(ResourceKey.create(Registries.BLOCK, FrameCage.id(path))))
        );

        if (itemBiFunc != null) {
            FrameCageForge.ITEMS.register(path,
                    () -> itemBiFunc.apply(block.get(), itemProps.setId(
                    ResourceKey.create(Registries.ITEM, FrameCage.id(path))))
            );
        }
        return block;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends EntityType<T>, T extends Entity> Supplier<E> entityType(
            String path,
            EntityType.Builder<T> builder
    ) {
        return FrameCageForge.ENTITY_TYPES.register(path, () -> (E) builder.build(
                ResourceKey.create(Registries.ENTITY_TYPE, FrameCage.id(path))));

    }

    @SuppressWarnings("unchecked")
    @Override
    public <G extends CreativeModeTab> Supplier<G> creativeModeTab(
            String path,
            UnaryOperator<CreativeModeTab.Builder> builderFunc
    ) {
        return FrameCageForge.CREATIVE_MODE_TABS.register(
                path, () -> (G) builderFunc.apply(CreativeModeTab.builder())
                        .title(Component.translatable(
                                String.format("itemGroup.%s.%s", FrameCage.MOD_ID, path)))
                        .build()
        );
    }


}
