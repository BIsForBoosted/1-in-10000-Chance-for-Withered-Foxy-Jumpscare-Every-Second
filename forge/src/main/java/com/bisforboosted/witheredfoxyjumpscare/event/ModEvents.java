package com.bisforboosted.witheredfoxyjumpscare.event;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.client.Minecraft;
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

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();

        // Only run while in game
        if (mc.level == null) {
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
                System.out.println("Doing jumpscare");
                JumpscareHudRenderer.setShouldRender(true);
                jumpscareTicks = 13;
            }

            tickCount = 0;
        }
    }
}
