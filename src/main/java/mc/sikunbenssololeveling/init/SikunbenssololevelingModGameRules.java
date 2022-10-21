
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mc.sikunbenssololeveling.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SikunbenssololevelingModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> FATIGUEENABLED = GameRules.register("fatigueEnabled", GameRules.Category.MISC,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> STARTASPLAYER = GameRules.register("startAsPlayer", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
}
