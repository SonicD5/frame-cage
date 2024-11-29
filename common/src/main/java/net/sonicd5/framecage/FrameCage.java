package net.sonicd5.framecage;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import static net.sonicd5.framecage.platform.Services.PLATFORM;

public class FrameCage {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "framecage";

    public static void init() {
        LOGGER.info("Successful launch on {}", PLATFORM.getPlatformName());
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}