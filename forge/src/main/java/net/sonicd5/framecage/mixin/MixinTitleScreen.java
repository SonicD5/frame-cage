package net.sonicd5.framecage.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.sonicd5.framecage.FrameCage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {

        FrameCage.LOGGER.info("This line is printed by an example mod mixin from Forge!");
        FrameCage.LOGGER.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}