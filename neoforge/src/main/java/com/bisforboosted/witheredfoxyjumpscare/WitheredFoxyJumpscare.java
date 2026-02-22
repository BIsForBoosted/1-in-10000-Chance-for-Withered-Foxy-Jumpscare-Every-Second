package com.bisforboosted.witheredfoxyjumpscare;


import com.bisforboosted.witheredfoxyjumpscare.sounds.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class WitheredFoxyJumpscare {

    public WitheredFoxyJumpscare(IEventBus modEventBus) {

        // God only knows why this doesn't work or produce any error logs
        // Going to consider NeoForge a bust for 1.20.4
        Constants.LOG.info("Initializing Common objects for NeoForge");
        CommonClass.init();
        Constants.LOG.info("Common objects loaded for NeoForge");

        ModSounds.SOUND_EVENTS.register(modEventBus);

        Constants.LOG.info("NeoForge objects initialized");
    }
}