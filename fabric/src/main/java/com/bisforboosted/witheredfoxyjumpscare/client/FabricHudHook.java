package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

public class FabricHudHook implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(VanillaHudElements.CROSSHAIR, Constants.WITHERED_FOXY_JUMPSCARE_1, JumpscareHudRenderer::render);
    }
}
