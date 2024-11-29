package net.sonicd5.framecage;

import net.fabricmc.api.ModInitializer;
import net.sonicd5.framecage.registry.FCBlocks;
import net.sonicd5.framecage.registry.FCCreativeModeTabs;
import net.sonicd5.framecage.registry.FCEntities;
import net.sonicd5.framecage.registry.FCItems;

public class FrameCageFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FCItems.init();
        FCBlocks.init();
        FCEntities.init();
        FCCreativeModeTabs.init();


        // Multiplatform Initialization
        FrameCage.init();
    }
}
