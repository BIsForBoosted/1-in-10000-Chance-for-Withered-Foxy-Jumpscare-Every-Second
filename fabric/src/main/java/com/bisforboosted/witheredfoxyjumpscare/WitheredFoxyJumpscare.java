package com.bisforboosted.witheredfoxyjumpscare;

import net.fabricmc.api.ModInitializer;

public class WitheredFoxyJumpscare implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Initializing Common objects for Fabric");
        CommonClass.init();
        Constants.LOG.info("Common objects loaded for Fabric");

        Constants.LOG.info("Fabric objects initialized");
    }
}
