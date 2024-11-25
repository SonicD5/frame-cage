package net.sonicd5.framecage;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.sonicd5.framecage.platform.Services;
import org.slf4j.Logger;


public class FrameCage {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "framecage";

    public static void init() {
        LOGGER.info("Successful launch on {}", Services.PLATFORM.getPlatformName());
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}