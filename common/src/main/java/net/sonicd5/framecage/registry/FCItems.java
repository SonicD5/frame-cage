package net.sonicd5.framecage.registry;

import net.minecraft.world.item.Item;
import net.sonicd5.framecage.item.RustBrushItem;
import net.sonicd5.framecage.platform.Services;

import java.util.function.Supplier;

public class FCItems {

    public static Supplier<Item> RUST_BRUSH = Services.REGISTRY.registerItem(
            "rust_brush", RustBrushItem::new
    );


    public static void init() {}
    public static void init(Runnable work) {
        work.run();
    }
}
