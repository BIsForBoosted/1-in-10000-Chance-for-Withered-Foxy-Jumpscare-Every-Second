package com.bisforboosted.witheredfoxyjumpscare.sounds;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Constants.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> JUMPSCARE_SOUND =
            SOUND_EVENTS.register("witheredfoxyjumpscare",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(Constants.MOD_ID, "witheredfoxyjumpscare")
                    ));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}