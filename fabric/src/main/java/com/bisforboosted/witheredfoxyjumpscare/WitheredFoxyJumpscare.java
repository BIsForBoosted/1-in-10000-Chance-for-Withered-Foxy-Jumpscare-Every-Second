package com.bisforboosted.witheredfoxyjumpscare;

import com.bisforboosted.witheredfoxyjumpscare.commands.CommonCommands;
import com.bisforboosted.witheredfoxyjumpscare.events.FabricJumpscareEvent;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.network.chat.Component;

public class WitheredFoxyJumpscare implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Constants.LOG.info("Initializing Common objects for Fabric");
        CommonClass.init();
        Constants.LOG.info("Common objects loaded for Fabric");
        ClientTickEvents.START_CLIENT_TICK.register(new FabricJumpscareEvent());

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("setjumpscareodds")
                .then(ClientCommandManager.argument("odds", IntegerArgumentType.integer(1))
                    .executes(context -> {
                        CommonCommands.CommandOutput output = CommonCommands.changeJumpscareOdds(context);
                        int result = output.result();
                        if (result == 0){
                            context.getSource().sendFeedback(Component.literal("Failed to set jumpscare odds"));
                        } else {
                            context.getSource().sendFeedback(Component.literal("New jumpscare odds set to 1/" + output.odds() + "!"));
                        }
                        return result;
                    })
                )
            );
        });

        Constants.LOG.info("Fabric objects initialized");
    }
}
