package com.bisforboosted.witheredfoxyjumpscare.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class FabricHudHook implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            JumpscareHudRenderer.render(context);
        });
    }
}
