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
                System.out.println("Animation started at tick: " + animationStartTime);
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

        System.out.println("Rendering frame at elapsed: " + elapsed + "/" + 13);

        if (elapsed > 13) {
            System.out.println("Animation complete at elapsed: " + elapsed);
            shouldRender = false;
            animationStartTime = -1L;
            return;
        }

        int screenWidth = context.guiWidth();
        int screenHeight = context.guiHeight();

        int imgWidth = 336;
        int imgHeight = 336;

        float scale = Math.min((float) screenWidth / imgWidth,
                (float) screenHeight / imgHeight);
        if (scale <= 0f) scale = 1f;

        int drawWidth = Math.max(1, Math.round(imgWidth * scale));
        int drawHeight = Math.max(1, Math.round(imgHeight * scale));

        int x = (screenWidth - drawWidth) / 2;
        int y = (screenHeight - drawHeight) / 2;

        context.blitSprite(RenderPipelines.GUI_TEXTURED, Utils.getIdentifierByTick(((int) elapsed)), x, y, drawWidth, drawHeight);
    }
}