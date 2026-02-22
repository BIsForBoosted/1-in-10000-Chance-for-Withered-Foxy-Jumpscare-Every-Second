package com.bisforboosted.witheredfoxyjumpscare.event;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import com.bisforboosted.witheredfoxyjumpscare.events.JumpscareEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent.Pre event) {
        JumpscareEvent.commonTickEvent(event);
    }
}
