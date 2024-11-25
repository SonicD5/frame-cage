package net.sonicd5.framecage.platform;

import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.platform.services.IPlatformHelper;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        FrameCage.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}