package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

public class JumpscareHudRenderer {
    public static final Identifier WITHERED_FOXY_JUMPSCARE =
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "hud/withered_foxy_jumpscare");

    private static boolean isActive = false;
    private static long animationStartTime = -1L;

    private static final int FRAME_COUNT = 13;
    private static final int TICKS_PER_FRAME = 1;
    private static final int TOTAL_ANIMATION_TICKS = FRAME_COUNT * TICKS_PER_FRAME;

    private JumpscareHudRenderer() {}

    public static void setShouldRender(boolean b) {
        System.out.println("Triggering jumpscare");
        isActive = b;
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
        return isActive;
    }

    public static void render(GuiGraphics context, DeltaTracker tickCount) {
        if (!isActive) return;

        var mc = Minecraft.getInstance();
        if (mc.level == null) return;

        long currentTime = mc.level.getGameTime();
        long elapsed = currentTime - animationStartTime;

        System.out.println("Rendering frame at elapsed: " + elapsed + "/" + TOTAL_ANIMATION_TICKS);

        if (elapsed > TOTAL_ANIMATION_TICKS) {
            System.out.println("Animation complete at elapsed: " + elapsed);
            isActive = false;
            animationStartTime = -1L;
            return;
        }

        int screenWidth = context.guiWidth();
        int screenHeight = context.guiHeight();

        int imgWidth = 664;
        int imgHeight = 664;

        float scale = Math.min((float) screenWidth / imgWidth,
                (float) screenHeight / imgHeight);
        if (scale <= 0f) scale = 1f;

        int drawWidth = Math.max(1, Math.round(imgWidth * scale));
        int drawHeight = Math.max(1, Math.round(imgHeight * scale));

        int x = (screenWidth - drawWidth) / 2;
        int y = (screenHeight - drawHeight) / 2;

        context.blitSprite(RenderPipelines.GUI_TEXTURED, WITHERED_FOXY_JUMPSCARE, x, y, drawWidth, drawHeight);
    }
}