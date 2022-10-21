package mc.sikunbenssololeveling.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetDebugProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = BoolArgumentType.getBool(arguments, "logic");
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DebugMode = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "Target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("\u00A7aSet debug mode to \u00A7l\u00A75" + BoolArgumentType.getBool(arguments, "logic")
					+ "\u00A7r\u00A7a for \u00A7l\u00A76" + (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "Target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getDisplayName().getString())), (false));
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "Target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("\u00A7aDebug Mode is now \u00A7l\u00A75" + BoolArgumentType.getBool(arguments, "logic"))), (false));
	}
}
