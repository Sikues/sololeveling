package mc.sikunbenssololeveling.procedures;

import net.minecraft.world.level.LevelAccessor;

import mc.sikunbenssololeveling.init.SikunbenssololevelingModGameRules;

public class FatiguereturnbackbarProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(SikunbenssololevelingModGameRules.FATIGUEENABLED);
	}
}
