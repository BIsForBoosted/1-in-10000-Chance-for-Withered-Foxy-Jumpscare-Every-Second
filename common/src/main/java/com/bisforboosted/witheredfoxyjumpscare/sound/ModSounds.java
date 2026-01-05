package com.bisforboosted.witheredfoxyjumpscare.sound;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import java.util.Optional;

public class ModSounds {
    public static final SoundEvent JUMPSCARE_SOUND = SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "witheredfoxyjumpscare"));
}
