package mc.sikunbenssololeveling.procedures;

import net.minecraft.world.entity.Entity;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

public class Stmbar10Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).currentstamina == (entity
						.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).maxstamina
				|| (entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).currentstamina > (entity
								.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).maxstamina) {
			return true;
		}
		return false;
	}
}
