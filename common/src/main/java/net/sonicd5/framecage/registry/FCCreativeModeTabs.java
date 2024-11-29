package net.sonicd5.framecage.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

import static net.sonicd5.framecage.platform.Services.REGISTRY;

public class FCCreativeModeTabs {

    public static final Supplier<CreativeModeTab> GUNS = REGISTRY.creativeModeTab(
            "guns", builder -> builder
                    .icon(() -> new ItemStack(FCItems.RUST_BRUSH.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(FCItems.RUST_BRUSH.get());
                    })

    );

    public static final Supplier<CreativeModeTab> MISC = REGISTRY.creativeModeTab(
            "misc", builder -> builder
                    .icon(() -> new ItemStack(FCItems.RUST_BRUSH.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(FCItems.RUST_BRUSH.get());
                    })
    );

    public static void init() {}
    public static void init(Runnable work) {
        work.run();
    }
}
