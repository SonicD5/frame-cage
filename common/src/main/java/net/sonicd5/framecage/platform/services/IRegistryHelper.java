package net.sonicd5.framecage.platform.services;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistryHelper {

    <I extends Item> Supplier<I> registerItem(
            String path,
            Function<Item.Properties, I> function,
            I.Properties properties
    );

    default <I extends Item> Supplier<I> registerItem(
            String path,
            Function<I.Properties, I> function
    ) {
        return registerItem(path, function, new Item.Properties());
    }

    @SuppressWarnings("unchecked")
    default <I extends Item> Supplier<I> registerItem(
            String path,
            I.Properties properties
    ) {
        return (Supplier<I>) registerItem(path, Item::new, properties);
    }

    default <I extends Item> Supplier<I> registerItem(String path) {
        return registerItem(path, new Item.Properties());
    }

    Supplier<SoundEvent> registerSound(String path);

    <B extends Block> Supplier<B> registerBlock(
            String path,
            Function<B.Properties, B> function

    );
}
