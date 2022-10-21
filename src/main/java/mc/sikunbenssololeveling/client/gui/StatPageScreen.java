
package mc.sikunbenssololeveling.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import mc.sikunbenssololeveling.world.inventory.StatPageMenu;
import mc.sikunbenssololeveling.network.SikunbenssololevelingModVariables;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StatPageScreen extends AbstractContainerScreen<StatPageMenu> {
	private final static HashMap<String, Object> guistate = StatPageMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public StatPageScreen(StatPageMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 152;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/stats.png"));
		this.blit(ms, this.leftPos + -6, this.topPos + -2, 0, 0, 200, 200, 200, 200);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,
				"\u00A7lStrength: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).Strength) + "",
				0, 48, -1);
		this.font.draw(poseStack,
				"\u00A7lVitality: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).vitality) + "",
				0, 69, -1);
		this.font.draw(poseStack,
				"\u00A7lAgility: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).agility) + "",
				0, 90, -1);
		this.font.draw(poseStack,
				"\u00A7lIntelligence: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).Intelligence) + "",
				0, 110, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + -16, this.topPos + 42, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + -16, this.topPos + 63, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + -16, this.topPos + 84, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + -16, this.topPos + 105, 9, 20, new TextComponent("+"), e -> {
		}));
	}
}
