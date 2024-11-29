package net.sonicd5.framecage.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import static net.sonicd5.framecage.platform.Services.REGISTRY;

import java.util.function.Supplier;

public class FCEntities {

    public static void init() {}
    public static void init(Runnable work) {
        work.run();
    }
}
