package com.bisforboosted.witheredfoxyjumpscare.events;

import com.bisforboosted.witheredfoxyjumpscare.client.JumpscareHudRenderer;
import com.bisforboosted.witheredfoxyjumpscare.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import java.util.Random;

public class ModEvents {
    private static int tickCount = 0;
    private static int jumpscareTicks = 0;

    private static final Random random = new Random();
    private static int jumpscareOdds = 10000;

    public static void onClientTick(ClientTickEvent.Pre event) {
        ClientLevel level = Minecraft.getInstance().level;

        // Only run while in game
        if (level == null) {
            return;
        }

        tickCount ++;

        if (jumpscareTicks > 0) {
            jumpscareTicks--;
            if (jumpscareTicks == 0) {
                JumpscareHudRenderer.setShouldRender(false);
            }
        }

        if (tickCount == 20) {
            int r = random.nextInt(jumpscareOdds);

            if (r == 0) {
                JumpscareHudRenderer.setShouldRender(true);
                jumpscareTicks = 13;
                level.playPlayerSound(ModSounds.JUMPSCARE_SOUND, SoundSource.HOSTILE, 1f, 1f);
            }

            tickCount = 0;
        }
    }
}
