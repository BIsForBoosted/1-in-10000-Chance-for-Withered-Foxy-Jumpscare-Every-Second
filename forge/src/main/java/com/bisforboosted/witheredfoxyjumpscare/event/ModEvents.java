package com.bisforboosted.witheredfoxyjumpscare.event;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import com.bisforboosted.witheredfoxyjumpscare.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.bisforboosted.witheredfoxyjumpscare.client.JumpscareHudRenderer;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEvents {

    private static int tickCount = 0;
    private static int jumpscareTicks = 0;

    private static final Random random = new Random();
    private static int jumpscareOdds = 10000;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent.Pre event) {
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
