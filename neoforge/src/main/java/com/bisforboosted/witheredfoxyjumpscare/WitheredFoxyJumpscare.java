package com.bisforboosted.witheredfoxyjumpscare;


import com.bisforboosted.witheredfoxyjumpscare.client.NeoForgeHudHook;
import com.bisforboosted.witheredfoxyjumpscare.events.ModEvents;
import com.bisforboosted.witheredfoxyjumpscare.sound.ModSounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.ref.SoftReference;
import java.util.function.Supplier;

@Mod(Constants.MOD_ID)
public class WitheredFoxyJumpscare {

    public WitheredFoxyJumpscare(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Initializing Common objects for NeoForge");
        CommonClass.init();
        Constants.LOG.info("Common objects loaded for NeoForge");
        NeoForge.EVENT_BUS.addListener(ModEvents::onClientTick);
        eventBus.addListener(NeoForgeHudHook::onRegisterOverlays);
        Constants.LOG.info("NeoForge objects initialized");
    }
}