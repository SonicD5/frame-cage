package net.sonicd5.framecage;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
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
import net.sonicd5.framecage.registry.FCBlocks;
import net.sonicd5.framecage.registry.FCCreativeModeTabs;
import net.sonicd5.framecage.registry.FCEntities;
import net.sonicd5.framecage.registry.FCItems;

@Mod(FrameCage.MOD_ID)
public class FrameCageForge {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, FrameCage.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, FrameCage.MOD_ID);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, FrameCage.MOD_ID);

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(
            ForgeRegistries.PARTICLE_TYPES, FrameCage.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
            ForgeRegistries.ENTITY_TYPES, FrameCage.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, FrameCage.MOD_ID);

    public FrameCageForge(FMLJavaModLoadingContext modLoadingContext) {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus modEventBus = modLoadingContext.getModEventBus();

        FCItems.init(() -> ITEMS.register(modEventBus));
        FCBlocks.init(() -> BLOCKS.register(modEventBus));
        FCEntities.init(() -> ENTITY_TYPES.register(modEventBus));
        FCCreativeModeTabs.init(() -> CREATIVE_MODE_TABS.register(modEventBus));

        FrameCage.init();
    }


}