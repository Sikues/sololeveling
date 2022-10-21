package mc.sikunbenssololeveling.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;
import mc.sikunbenssololeveling.init.SikunbenssololevelingModGameRules;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class GameRuleSetPlayerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(SikunbenssololevelingModGameRules.STARTASPLAYER) == true) {
			if ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).IsPlayer == false) {
				if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements()
								.getOrStartProgress(
										_plr.server.getAdvancements().getAdvancement(new ResourceLocation("sikunbenssololeveling:player")))
								.isDone()
						: false)) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sikunbenssololeveling:player"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
					{
						boolean _setval = true;
						entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.IsPlayer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsPlayer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
