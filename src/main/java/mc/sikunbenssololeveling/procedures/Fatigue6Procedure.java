package mc.sikunbenssololeveling.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;
import mc.sikunbenssololeveling.init.SikunbenssololevelingModGameRules;

public class Fatigue6Procedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).currentfatigue > (60
						* (entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).fatigue)
						/ 100
				&& world.getLevelData().getGameRules().getBoolean(SikunbenssololevelingModGameRules.FATIGUEENABLED) == true) {
			return true;
		}
		return false;
	}
}
