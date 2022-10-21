
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

import mc.sikunbenssololeveling.procedures.Stmpbar6Procedure;
import mc.sikunbenssololeveling.procedures.Stmpb2Procedure;
import mc.sikunbenssololeveling.procedures.Stmbar9Procedure;
import mc.sikunbenssololeveling.procedures.Stmbar8Procedure;
import mc.sikunbenssololeveling.procedures.Stmbar7Procedure;
import mc.sikunbenssololeveling.procedures.Stmbar5Procedure;
import mc.sikunbenssololeveling.procedures.Stmbar10Procedure;
import mc.sikunbenssololeveling.procedures.Stmb4Procedure;
import mc.sikunbenssololeveling.procedures.Stmb3Procedure;
import mc.sikunbenssololeveling.procedures.StaminaBar1Procedure;
import mc.sikunbenssololeveling.procedures.SkillsOverlayDisplayOverlayIngameProcedure;
import mc.sikunbenssololeveling.procedures.FatiguereturnbackbarProcedure;
import mc.sikunbenssololeveling.procedures.FatiguemaxProcedure;
import mc.sikunbenssololeveling.procedures.FatigueBarProcedure;
import mc.sikunbenssololeveling.procedures.Fatigue9Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue8Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue7Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue6Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue5Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue4Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue3Procedure;
import mc.sikunbenssololeveling.procedures.Fatigue2Procedure;
import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SkillsOverlayOverlay {
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
				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/slottype2.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -211, posY + 81, 0, 0, 39, 38, 39, 38);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -171, posY + 91, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -150, posY + 91, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -129, posY + 91, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -202, posY + 83, 0, 0, 20, 35, 20, 35);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -166, posY + 92, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -145, posY + 92, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -124, posY + 92, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/emptybaruniversal.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 66, 0, 0, 104, 15, 104, 15);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/emptybaruniversal.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 52, 0, 0, 104, 15, 104, 15);

				if (StaminaBar1Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/10layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 10, 11, 10, 11);
				}
				if (Stmpb2Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/20layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 20, 11, 20, 11);
				}
				if (Stmb3Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/30layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 30, 11, 30, 11);
				}
				if (Stmb4Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/40layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 40, 11, 40, 11);
				}
				if (Stmbar5Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/50layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 51, 11, 51, 11);
				}
				if (Stmpbar6Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/60layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 60, 11, 60, 11);
				}
				if (Stmbar7Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/70player.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 70, 11, 70, 11);
				}
				if (Stmbar8Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/80layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 80, 11, 80, 11);
				}
				if (Stmbar9Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/90layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 90, 11, 90, 11);
				}
				if (Stmbar10Procedure.execute(entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/100layer.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 54, 0, 0, 102, 11, 102, 11);
				}
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"Level: " + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).level) + "",
						posX + -208, posY + 35, -1);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"Mana: " + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).currentstamina) + "/"
								+ (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).maxstamina)
								+ "",
						posX + -207, posY + 54, -1);
				if (FatiguereturnbackbarProcedure.execute(world)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/emptybaruniversal.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 46, 0, 0, 52, 7, 52, 7);
				}
				if (FatigueBarProcedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/10aura.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 5, 5, 5, 5);
				}
				if (Fatigue2Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/20aura.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 47, 0, 0, 10, 5, 10, 5);
				}
				if (Fatigue3Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura30.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 15, 5, 15, 5);
				}
				if (Fatigue4Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura40.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 20, 5, 20, 5);
				}
				if (Fatigue5Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura50.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 25, 5, 25, 5);
				}
				if (Fatigue6Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura60.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 30, 5, 30, 5);
				}
				if (Fatigue7Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura70.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 35, 5, 35, 5);
				}
				if (Fatigue8Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura80.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 40, 5, 40, 5);
				}
				if (Fatigue9Procedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura90.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 47, 0, 0, 45, 5, 45, 5);
				}
				if (FatiguemaxProcedure.execute(world, entity)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/aura100.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -209, posY + 47, 0, 0, 51, 5, 51, 5);
				}
				if (FatiguereturnbackbarProcedure.execute(world)) {
					RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/rim.png"));
					Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 46, 0, 0, 52, 7, 52, 7);
				}
				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/rim.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -210, posY + 52, 0, 0, 104, 15, 104, 15);

			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
