package mc.sikunbenssololeveling.procedures;

import net.minecraft.world.entity.Entity;

import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

public class XpbarProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).cxp > (9
						* (entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).nxp)
						/ 100) {
			return true;
		}
		return false;
	}
}
