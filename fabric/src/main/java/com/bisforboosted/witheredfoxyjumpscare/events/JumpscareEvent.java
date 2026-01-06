package com.bisforboosted.witheredfoxyjumpscare.events;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import com.bisforboosted.witheredfoxyjumpscare.client.JumpscareHudRenderer;
import com.bisforboosted.witheredfoxyjumpscare.sound.ModSounds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class JumpscareEvent implements ClientTickEvents.StartTick {
    private static int tickCount = 0;
    private static int jumpscareTicks = 0;

    @Override
    public void onStartTick(Minecraft minecraft) {
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
            Random random = new Random();

            int r = random.nextInt(10);

            if (r == 0) {
                JumpscareHudRenderer.setShouldRender(true);
                jumpscareTicks = 13;
                level.playPlayerSound(ModSounds.JUMPSCARE_SOUND, SoundSource.HOSTILE, 1f, 1f);
            }

            tickCount = 0;
        }
    }
}
