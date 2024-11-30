package net.sonicd5.framecage;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.sonicd5.framecage.registry.FCBlocks;
import net.sonicd5.framecage.registry.FCCreativeModeTabs;
import net.sonicd5.framecage.registry.FCEntities;
import net.sonicd5.framecage.registry.FCItems;

@Mod(FrameCage.MOD_ID)
public class FrameCageForge {

    public static final DeferredRegister<Item> ITEMS = createDeferredRegister(
            ForgeRegistries.ITEMS);
    public static final DeferredRegister<Block> BLOCKS = createDeferredRegister(
            ForgeRegistries.BLOCKS);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = createDeferredRegister(
            ForgeRegistries.SOUND_EVENTS);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = createDeferredRegister(
            ForgeRegistries.PARTICLE_TYPES);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = createDeferredRegister(
            ForgeRegistries.ENTITY_TYPES);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = createDeferredRegister(
            Registries.CREATIVE_MODE_TAB);

    public FrameCageForge(FMLJavaModLoadingContext modLoadingContext) {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus modEventBus = modLoadingContext.getModEventBus();

        FCItems.init(() -> ITEMS.register(modEventBus));
        FCBlocks.init(() -> BLOCKS.register(modEventBus));
        FCEntities.init(() -> ENTITY_TYPES.register(modEventBus));
        FCCreativeModeTabs.init(() -> CREATIVE_MODE_TABS.register(modEventBus));

        FrameCage.init();
    }

    private static <T> DeferredRegister<T> createDeferredRegister(IForgeRegistry<T> reg) {
        return DeferredRegister.create(reg, FrameCage.MOD_ID);
    }

    private static <T> DeferredRegister<T> createDeferredRegister(ResourceKey<? extends Registry<T>> key) {
        return DeferredRegister.create(key, FrameCage.MOD_ID);
    }



}