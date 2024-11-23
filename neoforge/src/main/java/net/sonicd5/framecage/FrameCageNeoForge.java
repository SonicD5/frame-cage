package net.sonicd5.framecage;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FrameCage.MOD_ID)
public class FrameCageNeoForge {

    public FrameCageNeoForge(IEventBus eventBus) {
        FrameCage.init();
    }
}