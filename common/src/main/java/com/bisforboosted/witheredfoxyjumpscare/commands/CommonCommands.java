package com.bisforboosted.witheredfoxyjumpscare.commands;

import com.bisforboosted.witheredfoxyjumpscare.events.JumpscareEvent;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;

public class CommonCommands {
    public record CommandOutput(int result, int odds) {}

    public static <T> CommandOutput changeJumpscareOdds(CommandContext<T> context) {
        int odds = IntegerArgumentType.getInteger(context, "odds");
        JumpscareEvent.setJumpscareOdds(odds);
        return new CommandOutput(1, odds);
    }
}
