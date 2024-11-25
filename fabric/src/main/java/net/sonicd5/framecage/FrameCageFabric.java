package net.sonicd5.framecage;

import net.fabricmc.api.ModInitializer;
import net.sonicd5.framecage.registry.FCBlocks;
import net.sonicd5.framecage.registry.FCItems;

public class FrameCageFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FCItems.init();
        FCBlocks.init();

        // Multiplatform Initialization
        FrameCage.init();
    }
}
