package com.bisforboosted.witheredfoxyjumpscare.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

public class FabricJumpscareEvent implements ClientTickEvents.StartTick {
    @Override
    public void onStartTick(Minecraft minecraft) {
        JumpscareEvent.commonTickEvent(minecraft);
    }
}
