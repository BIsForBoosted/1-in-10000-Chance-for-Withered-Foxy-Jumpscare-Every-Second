package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import com.bisforboosted.witheredfoxyjumpscare.WitheredFoxyJumpScare;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.Identifier;
import net.minecraftforge.client.event.AddGuiOverlayLayersEvent;
import net.minecraftforge.client.gui.overlay.ForgeLayeredDraw;
import com.bisforboosted.witheredfoxyjumpscare.client.JumpscareHudRenderer;

public class ForgeHudHook {

    static {
        AddGuiOverlayLayersEvent.BUS.addListener(event -> {
                ForgeLayeredDraw layeredDraw = event.getLayeredDraw();

                layeredDraw.addWithCondition(ForgeLayeredDraw.VANILLA_ROOT,
                    JumpscareHudRenderer.WITHERED_FOXY_JUMPSCARE,
                    JumpscareHudRenderer::render,
                    JumpscareHudRenderer::getShouldRender);
        });
    }

    public static void init() {}

}
