package com.bisforboosted.witheredfoxyjumpscare;

import com.bisforboosted.witheredfoxyjumpscare.event.ModEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class WitheredFoxyJumpScare {

    public WitheredFoxyJumpScare() {

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Initializing Common objects for Forge");
        CommonClass.init();
        Constants.LOG.info("Common objects loaded for Forge");

        Constants.LOG.info("Forge objects initialized");
    }
}