package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

public class NeoForgeHudHook {

    public static void onRegisterOverlays(RegisterGuiLayersEvent event) {
        event.registerAboveAll(Constants.WITHERED_FOXY_JUMPSCARE_1, JumpscareHudRenderer::render);
    }
}
