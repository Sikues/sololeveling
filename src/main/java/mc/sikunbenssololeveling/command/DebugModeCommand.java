
package mc.sikunbenssololeveling.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import mc.sikunbenssololeveling.procedures.SetDebugProcedure;

import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class DebugModeCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("debugmode").requires(s -> s.hasPermission(4)).then(
				Commands.argument("Target", EntityArgument.player()).then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SetDebugProcedure.execute(arguments, entity);
					return 0;
				}))));
	}
}
