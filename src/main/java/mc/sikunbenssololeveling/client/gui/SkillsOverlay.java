
package mc.sikunbenssololeveling.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import mc.sikunbenssololeveling.procedures.SkillsOverlayDisplayOverlayIngameProcedure;
import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SkillsOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (SkillsOverlayDisplayOverlayIngameProcedure.execute(entity)) {
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot1ability) + "",
						posX + 156, posY + 16, -16777216);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot1ability) + "",
								posX + 155, posY + 15, -1);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot2ability) + "",
						posX + 155, posY + 39, -16777216);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot2ability) + "",
								posX + 154, posY + 38, -1);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot3ability) + "",
						posX + 156, posY + 60, -16777216);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot3ability) + "",
								posX + 155, posY + 59, -1);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot4ability) + "",
						posX + 156, posY + 81, -16777216);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).slot4ability) + "",
								posX + 155, posY + 80, -1);
				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/slottype2.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 44, 0, 0, 39, 38, 39, 38);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 192, posY + 51, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 192, posY + 30, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 192, posY + 9, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 192, posY + 72, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -200, posY + 46, 0, 0, 20, 35, 20, 35);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 197, posY + 10, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 197, posY + 31, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 197, posY + 52, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 197, posY + 73, 0, 0, 10, 17, 10, 17);

			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
