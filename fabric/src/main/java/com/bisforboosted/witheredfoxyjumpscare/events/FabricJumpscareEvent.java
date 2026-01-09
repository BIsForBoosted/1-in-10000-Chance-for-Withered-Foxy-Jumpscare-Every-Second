package com.bisforboosted.witheredfoxyjumpscare.events;

import com.bisforboosted.witheredfoxyjumpscare.client.JumpscareHudRenderer;
import com.bisforboosted.witheredfoxyjumpscare.sound.ModSounds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.sounds.SoundSource;

import java.util.Random;

public class FabricJumpscareEvent implements ClientTickEvents.StartTick {
    @Override
    public void onStartTick(Minecraft minecraft) {
        JumpscareEvent.commonTickEvent(minecraft);
    }
}
