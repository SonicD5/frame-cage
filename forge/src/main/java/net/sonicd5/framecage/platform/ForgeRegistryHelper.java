package net.sonicd5.framecage.platform;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.FrameCageForge;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.function.Function;
import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {

    @Override
    public <I extends Item> Supplier<I> registerItem(
            String path, Function<I.Properties, I> function, Item.Properties properties
    ) {
        return FrameCageForge.ITEMS.register(path,
                () -> function.apply(properties.setId(
                ResourceKey.create(Registries.ITEM, FrameCage.id(path))))
        );
    }

    @Override
    public Supplier<SoundEvent> registerSound(String path) {
        return FrameCageForge.SOUNDS.register(
                path, () -> SoundEvent.createVariableRangeEvent(FrameCage.id(path))
        );
    }


}
