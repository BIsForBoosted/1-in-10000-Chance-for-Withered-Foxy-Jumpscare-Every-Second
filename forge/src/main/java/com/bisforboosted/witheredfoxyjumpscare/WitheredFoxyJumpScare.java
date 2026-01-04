package com.bisforboosted.witheredfoxyjumpscare;

import com.bisforboosted.witheredfoxyjumpscare.client.ForgeHudHook;
import com.bisforboosted.witheredfoxyjumpscare.event.ModEvents;

import net.minecraftforge.client.gui.overlay.ForgeLayeredDraw;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.lang.reflect.Field;

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
        System.out.println("WitheredFoxyJumpScare: calling ForgeHudHook.init()");
        for (Field f : ForgeLayeredDraw.class.getFields()) {
        System.out.println("ForgeLayeredDraw constant: " + f.getName());
    }
        ForgeHudHook.init();
        System.out.println("WitheredFoxyJumpScare: ForgeHudHook.init() returned");

        Constants.LOG.info("Forge objects initialized");
    }
}