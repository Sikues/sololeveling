
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mc.sikunbenssololeveling.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import mc.sikunbenssololeveling.client.gui.StatPageScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SikunbenssololevelingModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SikunbenssololevelingModMenus.STAT_PAGE, StatPageScreen::new);
		});
	}
}
