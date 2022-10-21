
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
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -212, posY + 61, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -191, posY + 61, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -212, posY + 41, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -191, posY + 41, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -212, posY + 21, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/smalltype1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -191, posY + 21, 0, 0, 20, 19, 20, 19);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -202, posY + 83, 0, 0, 20, 35, 20, 35);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -186, posY + 62, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -207, posY + 62, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -207, posY + 42, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -186, posY + 42, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -186, posY + 22, 0, 0, 10, 17, 10, 17);

				RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/hourglass.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -207, posY + 22, 0, 0, 10, 17, 10, 17);

			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
