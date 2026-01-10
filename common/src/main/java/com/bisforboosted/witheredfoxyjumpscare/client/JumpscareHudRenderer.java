package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.util.Utils;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;

public class JumpscareHudRenderer {
    private static boolean shouldRender = false;
    private static long animationStartTime = -1L;

    private JumpscareHudRenderer() {}

    public static void setShouldRender(boolean b) {
        shouldRender = b;
        if (b) {
            var mc = Minecraft.getInstance();
            if (mc.level != null) {
                animationStartTime = mc.level.getGameTime();
            } else {
                animationStartTime = 0L;
            }
        }
    }

    public static boolean getShouldRender() {
        return shouldRender;
    }

    public static void render(GuiGraphics context, DeltaTracker tickCount) {
        if (!shouldRender) return;

        var mc = Minecraft.getInstance();
        if (mc.level == null) return;

        long currentTime = mc.level.getGameTime();
        long elapsed = currentTime - animationStartTime;

        if (elapsed > 13) {
            shouldRender = false;
            animationStartTime = -1L;
            return;
        }

        context.blitSprite(RenderPipelines.GUI_TEXTURED, Utils.getIdentifierByTick(((int) elapsed)), 0, 0, context.guiWidth(), context.guiHeight());
    }
}