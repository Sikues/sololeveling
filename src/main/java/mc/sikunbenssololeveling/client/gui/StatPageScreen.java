
package mc.sikunbenssololeveling.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
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
	EditBox amount;

	public StatPageScreen(StatPageMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 157;
		this.imageHeight = 197;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		amount.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("sikunbenssololeveling:textures/screens/statpageback.png"));
		this.blit(ms, this.leftPos + -1, this.topPos + -3, 0, 0, 159, 202, 159, 202);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (amount.isFocused())
			return amount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		amount.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "\u00A7lStrength: ", 16, 89, -16777216);
		this.font.draw(poseStack,
				"\u00A7lStrength: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).Strength) + "",
				15, 88, -1);
		this.font.draw(poseStack, "\u00A7lVitality:", 16, 69, -16777216);
		this.font.draw(poseStack,
				"\u00A7lVitality: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).vitality) + "",
				15, 68, -1);
		this.font.draw(poseStack, "\u00A7lAgility:", 16, 49, -16777216);
		this.font.draw(poseStack,
				"\u00A7lAgility: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).agility) + "",
				15, 48, -1);
		this.font.draw(poseStack, "\u00A7lIntelligence:", 16, 109, -16777216);
		this.font.draw(poseStack,
				"\u00A7lIntelligence: \u00A7r" + (int) ((entity.getCapability(SikunbenssololevelingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SikunbenssololevelingModVariables.PlayerVariables())).Intelligence) + "",
				15, 108, -1);
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
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 41, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 61, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 81, 9, 20, new TextComponent("+"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 101, 9, 20, new TextComponent("+"), e -> {
		}));
		amount = new EditBox(this.font, this.leftPos + 98, this.topPos + 129, 55, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:amount", amount);
		amount.setMaxLength(32767);
		this.addWidget(this.amount);
	}
}
