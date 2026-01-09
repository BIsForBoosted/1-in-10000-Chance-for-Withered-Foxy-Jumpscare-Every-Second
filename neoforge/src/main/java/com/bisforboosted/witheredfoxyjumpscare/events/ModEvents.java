package com.bisforboosted.witheredfoxyjumpscare.events;

import net.neoforged.neoforge.client.event.ClientTickEvent;

public class ModEvents {
    public static void onClientTick(ClientTickEvent.Pre event) {
        JumpscareEvent.commonTickEvent(event);
    }
}
