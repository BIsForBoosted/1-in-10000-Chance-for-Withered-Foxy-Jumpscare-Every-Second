package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.GuiLayer;
import net.neoforged.neoforge.client.gui.GuiLayerManager.NamedLayer;

public class NeoForgeHudHook {

    public static void onRegisterOverlays(RegisterGuiLayersEvent event) {
        event.registerAboveAll(Constants.WITHERED_FOXY_JUMPSCARE_1, JumpscareHudRenderer::render);
    }
}
