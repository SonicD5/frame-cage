package net.sonicd5.framecage.platform;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.function.Function;
import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {

    @Override
    public <I extends Item> Supplier<I> registerItem(String path, Function<Item.Properties, I> function, Item.Properties properties) {
        return null;
    }

    @Override
    public <I extends Item> Supplier<I> registerItem(String path, Function<Item.Properties, I> function) {
        return null;
    }

    @Override
    public <I extends Item> Supplier<I> registerItem(String path, Item.Properties properties) {
        return null;
    }

    @Override
    public <I extends Item> Supplier<I> registerItem(String path) {
        return null;
    }

    @Override
    public Supplier<SoundEvent> registerSound(String path) {
        return null;
    }
}
