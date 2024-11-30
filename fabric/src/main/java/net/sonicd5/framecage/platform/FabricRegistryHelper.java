package net.sonicd5.framecage.platform;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public <I extends Item> Supplier<I> item(
            String path, Function<Item.Properties, I> itemFunc, Item.Properties properties
    ) {
        var resourceKey = ResourceKey.create(Registries.ITEM, FrameCage.id(path));
        final I item = itemFunc.apply(properties.setId(resourceKey));

        Registry.register(BuiltInRegistries.ITEM, resourceKey, item);

        return () -> item;
    }

    @Override
    public Supplier<SoundEvent> soundEvent(String path) {

        ResourceLocation location = FrameCage.id(path);
        final var soundEvent = SoundEvent.createVariableRangeEvent(location);

        Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                location, soundEvent
        );

        return () -> soundEvent;
    }

    @Override
    public <B extends Block, I extends BlockItem> Supplier<B> block(
            String path,
            Function<BlockBehaviour.Properties, B> blockFunc,
            BlockBehaviour.Properties blockProps,
            BiFunction<B, Item.Properties, I> itemBiFunc,
            Item.Properties itemProps
    ) {
        var blockResourceKey = ResourceKey.create(Registries.BLOCK, FrameCage.id(path));
        final B block = blockFunc.apply(blockProps.setId(blockResourceKey));

        Registry.register(BuiltInRegistries.BLOCK, blockResourceKey, block);

        if (itemBiFunc != null) {
            var itemResourceKey = ResourceKey.create(Registries.ITEM, FrameCage.id(path));

            Registry.register(
                    BuiltInRegistries.ITEM,
                    itemResourceKey, itemBiFunc.apply(block, itemProps.setId(itemResourceKey))
            );
        }

        return () -> block;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends EntityType<T>, T extends Entity> Supplier<E> entityType(String path, EntityType.Builder<T> builder) {
        var resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, FrameCage.id(path));
        final E entityType = (E) builder.build(resourceKey);

        Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, entityType);
        return () -> entityType;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <G extends CreativeModeTab> Supplier<G> creativeModeTab(
            String path,
            UnaryOperator<CreativeModeTab.Builder> builderFunc
    ) {
        final G creativeTab = (G) builderFunc.apply(FabricItemGroup.builder())
                .title(Component.translatable(String.format("itemGroup.%s.%s", FrameCage.MOD_ID, path)))
                .build();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, FrameCage.id(path), creativeTab);
        return () -> creativeTab;
    }


}
