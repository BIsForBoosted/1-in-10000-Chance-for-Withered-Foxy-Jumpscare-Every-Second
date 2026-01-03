package com.bisforboosted.witheredfoxyjumpscare;

import net.minecraftforge.fml.common.Mod;

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