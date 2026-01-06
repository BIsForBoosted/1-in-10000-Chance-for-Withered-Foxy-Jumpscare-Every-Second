package com.bisforboosted.witheredfoxyjumpscare.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

public class FabricHudHook implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(VanillaHudElements.CROSSHAIR, JumpscareHudRenderer.WITHERED_FOXY_JUMPSCARE, JumpscareHudRenderer::render);
    }
}
