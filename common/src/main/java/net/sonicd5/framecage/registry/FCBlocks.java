package net.sonicd5.framecage.registry;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static net.sonicd5.framecage.platform.Services.REGISTRY;

public class FCBlocks {

    public static final Supplier<Block> PLACEHOLDER = REGISTRY.block("placeholder", true);

    public static void init() {}
    public static void init(Runnable work) {
        work.run();
    }
}
