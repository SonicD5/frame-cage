package net.sonicd5.framecage.registry;

import net.minecraft.world.item.Item;
import net.sonicd5.framecage.item.RustBrushItem;

import java.util.function.Supplier;

import static net.sonicd5.framecage.platform.Services.REGISTRY;

public class FCItems {

    // Item with advanced functionality
    public static final Supplier<Item> RUST_BRUSH = REGISTRY.item("rust_brush", RustBrushItem::new);

    public static void init() {}
    public static void init(Runnable work) {
        work.run();
    }
}
