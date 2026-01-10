package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraftforge.client.event.AddGuiOverlayLayersEvent;
import net.minecraftforge.client.gui.overlay.ForgeLayeredDraw;

public class ForgeHudHook {

    public static void init() {
        AddGuiOverlayLayersEvent.BUS.addListener(ForgeHudHook::onRegisterOverlays);
    }

    private static void onRegisterOverlays(AddGuiOverlayLayersEvent event) {
        ForgeLayeredDraw layeredDraw = event.getLayeredDraw();

        layeredDraw.addWithCondition(
                ForgeLayeredDraw.VANILLA_ROOT,
                Constants.WITHERED_FOXY_JUMPSCARE_1,
                JumpscareHudRenderer::render,
                JumpscareHudRenderer::getShouldRender
        );
    }
}
