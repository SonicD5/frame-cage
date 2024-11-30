package net.sonicd5.framecage.platform;

import net.sonicd5.framecage.FrameCage;
import net.sonicd5.framecage.platform.services.IPlatformHelper;
import net.sonicd5.framecage.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> service) {

        final T loadedService = ServiceLoader.load(service)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(
                        "Failed to load service for " + service.getName()));

        FrameCage.LOGGER.debug("Loaded {} for service {}", loadedService, service);
        return loadedService;
    }
}