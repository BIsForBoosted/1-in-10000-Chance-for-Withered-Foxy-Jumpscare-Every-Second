package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;

public class NeoForgeHudHook {

    private static final IGuiOverlay JUMPSCARE_LAYER = (extendedGui, guiGraphics, partialTick, width, height) -> {
        JumpscareHudRenderer.render(guiGraphics);
    };

    public static void onRegisterOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll(Constants.WITHERED_FOXY_JUMPSCARE_1, JUMPSCARE_LAYER);
    }
}
