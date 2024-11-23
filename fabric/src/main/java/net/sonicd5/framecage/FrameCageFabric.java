package net.sonicd5.framecage;

import net.fabricmc.api.ModInitializer;

public class FrameCageFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FrameCage.init();
    }
}
