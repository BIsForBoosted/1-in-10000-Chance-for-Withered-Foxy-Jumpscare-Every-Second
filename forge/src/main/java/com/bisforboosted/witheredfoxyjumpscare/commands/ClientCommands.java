package com.bisforboosted.witheredfoxyjumpscare.commands;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientCommands {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterClientCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("setjumpscareodds")
                .then(Commands.argument("odds", IntegerArgumentType.integer(1))
                        .executes(context -> {
                            CommonCommands.CommandOutput output = CommonCommands.changeJumpscareOdds(context);
                            int result = output.result();
                            if (result == 0){
                                context.getSource().sendFailure(Component.literal("Failed to set jumpscare odds"));
                            } else {
                                context.getSource().sendSuccess(
                                        () -> Component.literal("New jumpscare odds set to 1/" + output.odds() + "!"),
                                        true
                                );
                            }
                            return result;
                        })
                ));
    }
}
