package net.sonicd5.framecage.platform;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.function.Function;
import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public <I extends Item> Supplier<I> registerItem(
            String path, Function<I.Properties, I> function, Item.Properties properties
    ) {
        ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, FrameCage.id(path));
        I item = function.apply(properties.setId(resourceKey));

        Registry.register(BuiltInRegistries.ITEM, resourceKey, item);

        return () -> item;
    }

    @Override
    public Supplier<SoundEvent> registerSound(String path) {
        ResourceLocation location = FrameCage.id(path);
        return () -> Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                location, SoundEvent.createVariableRangeEvent(location)
        );
    }
}
