package mc.sikunbenssololeveling.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AddXPonKillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).IsPlayer == true) {
				{
					double _setval = (sourceentity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).cxp
							+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 4;
					sourceentity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cxp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(
							new TextComponent(
									("\u00A7l\u00A7e+ " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 4) + "XP")),
							(true));
			}
		}
	}
}
