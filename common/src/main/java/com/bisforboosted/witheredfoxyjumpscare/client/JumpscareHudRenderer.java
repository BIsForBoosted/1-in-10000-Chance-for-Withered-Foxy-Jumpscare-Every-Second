package com.bisforboosted.witheredfoxyjumpscare.client;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class JumpscareHudRenderer {
    public static final Identifier WITHERED_FOXY_JUMPSCARE = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "hud/withered_foxy_jumpscare");
    private static boolean shouldRender = false;
    private static boolean renderQueued = false;
    private static Long initializedAt = -1L;
    private static final int PERIOD = 13;
    private static long scheduledStart = -1L;
    private static long startGameTime = -1L;
    private static long scheduledEnd = -1L;

    private JumpscareHudRenderer() {}

    public static void setShouldRender(boolean b) {
        System.out.println("Setting shouldRender to " + b);
        shouldRender = b;
    }
    public static boolean getShouldRender() {return shouldRender || scheduledStart > 0 || renderQueued;}


    public static void render(GuiGraphics context, DeltaTracker tickCount) {
        if (!shouldRender) return;
        int screenWidth = context.guiWidth();
        int screenHeight = context.guiHeight();

        // Original sprite size (pixels). Adjust if your source image differs.
        int imgWidth = 664;
        int imgHeight = 664;

        float scale = Math.min((float) screenWidth / imgWidth, (float) screenHeight / imgHeight);
        if (scale <= 0f) scale = 1f;

        int drawWidth = Math.max(1, Math.round(imgWidth * scale));
        int drawHeight = Math.max(1, Math.round(imgHeight * scale));

        int x = (screenWidth - drawWidth) / 2;
        int y = (screenHeight - drawHeight) / 2;

        context.blitSprite(RenderPipelines.GUI_TEXTURED, WITHERED_FOXY_JUMPSCARE, x, y, drawWidth, drawHeight);
    }
}
