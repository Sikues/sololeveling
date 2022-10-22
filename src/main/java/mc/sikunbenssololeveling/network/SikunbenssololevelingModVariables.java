package mc.sikunbenssololeveling.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import mc.sikunbenssololeveling.SikunbenssololevelingMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SikunbenssololevelingModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SikunbenssololevelingMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer,
				PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.IsPlayer = original.IsPlayer;
			clone.DebugMode = original.DebugMode;
			clone.nxp = original.nxp;
			clone.cxp = original.cxp;
			clone.level = original.level;
			clone.maxstamina = original.maxstamina;
			clone.slot1ability = original.slot1ability;
			clone.slot2ability = original.slot2ability;
			clone.slot3ability = original.slot3ability;
			clone.ultimateslot = original.ultimateslot;
			clone.Strength = original.Strength;
			clone.vitality = original.vitality;
			clone.Intelligence = original.Intelligence;
			clone.agility = original.agility;
			clone.name = original.name;
			clone.Title = original.Title;
			clone.Job = original.Job;
			clone.statpoints = original.statpoints;
			clone.Rank = original.Rank;
			clone.shadowdogs = original.shadowdogs;
			clone.shadowzombies = original.shadowzombies;
			clone.shadowskeletons = original.shadowskeletons;
			clone.shadowhorses = original.shadowhorses;
			clone.maxshadows = original.maxshadows;
			clone.miningmastery = original.miningmastery;
			clone.miningmcxp = original.miningmcxp;
			clone.miningmnxp = original.miningmnxp;
			clone.SwordMastery = original.SwordMastery;
			clone.swordcxp = original.swordcxp;
			clone.swordnxp = original.swordnxp;
			if (!event.isWasDeath()) {
				clone.currentstamina = original.currentstamina;
				clone.fatigue = original.fatigue;
				clone.currentfatigue = original.currentfatigue;
				clone.mpregencooldown = original.mpregencooldown;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("sikunbenssololeveling", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean IsPlayer = false;
		public boolean DebugMode = false;
		public double nxp = 100.0;
		public double cxp = 0;
		public double level = 0;
		public double currentstamina = 100.0;
		public double maxstamina = 100.0;
		public String slot1ability = "none";
		public String slot2ability = "none";
		public String slot3ability = "none";
		public String ultimateslot = "\"\"";
		public double fatigue = 36000.0;
		public double currentfatigue = 36000.0;
		public double Strength = 0;
		public double vitality = 0;
		public double Intelligence = 0;
		public double agility = 0;
		public String name = "N/A";
		public String Title = " ";
		public String Job = "none";
		public double statpoints = 15.0;
		public String Rank = "E";
		public double shadowdogs = 0;
		public double shadowzombies = 0;
		public double shadowskeletons = 0;
		public double shadowhorses = 0;
		public double maxshadows = 25.0;
		public double mpregencooldown = 0;
		public double miningmastery = 0;
		public double miningmcxp = 0.0;
		public double miningmnxp = 100.0;
		public double SwordMastery = 0;
		public double swordcxp = 0;
		public double swordnxp = 100.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				SikunbenssololevelingMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("IsPlayer", IsPlayer);
			nbt.putBoolean("DebugMode", DebugMode);
			nbt.putDouble("nxp", nxp);
			nbt.putDouble("cxp", cxp);
			nbt.putDouble("level", level);
			nbt.putDouble("currentstamina", currentstamina);
			nbt.putDouble("maxstamina", maxstamina);
			nbt.putString("slot1ability", slot1ability);
			nbt.putString("slot2ability", slot2ability);
			nbt.putString("slot3ability", slot3ability);
			nbt.putString("ultimateslot", ultimateslot);
			nbt.putDouble("fatigue", fatigue);
			nbt.putDouble("currentfatigue", currentfatigue);
			nbt.putDouble("Strength", Strength);
			nbt.putDouble("vitality", vitality);
			nbt.putDouble("Intelligence", Intelligence);
			nbt.putDouble("agility", agility);
			nbt.putString("name", name);
			nbt.putString("Title", Title);
			nbt.putString("Job", Job);
			nbt.putDouble("statpoints", statpoints);
			nbt.putString("Rank", Rank);
			nbt.putDouble("shadowdogs", shadowdogs);
			nbt.putDouble("shadowzombies", shadowzombies);
			nbt.putDouble("shadowskeletons", shadowskeletons);
			nbt.putDouble("shadowhorses", shadowhorses);
			nbt.putDouble("maxshadows", maxshadows);
			nbt.putDouble("mpregencooldown", mpregencooldown);
			nbt.putDouble("miningmastery", miningmastery);
			nbt.putDouble("miningmcxp", miningmcxp);
			nbt.putDouble("miningmnxp", miningmnxp);
			nbt.putDouble("SwordMastery", SwordMastery);
			nbt.putDouble("swordcxp", swordcxp);
			nbt.putDouble("swordnxp", swordnxp);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			IsPlayer = nbt.getBoolean("IsPlayer");
			DebugMode = nbt.getBoolean("DebugMode");
			nxp = nbt.getDouble("nxp");
			cxp = nbt.getDouble("cxp");
			level = nbt.getDouble("level");
			currentstamina = nbt.getDouble("currentstamina");
			maxstamina = nbt.getDouble("maxstamina");
			slot1ability = nbt.getString("slot1ability");
			slot2ability = nbt.getString("slot2ability");
			slot3ability = nbt.getString("slot3ability");
			ultimateslot = nbt.getString("ultimateslot");
			fatigue = nbt.getDouble("fatigue");
			currentfatigue = nbt.getDouble("currentfatigue");
			Strength = nbt.getDouble("Strength");
			vitality = nbt.getDouble("vitality");
			Intelligence = nbt.getDouble("Intelligence");
			agility = nbt.getDouble("agility");
			name = nbt.getString("name");
			Title = nbt.getString("Title");
			Job = nbt.getString("Job");
			statpoints = nbt.getDouble("statpoints");
			Rank = nbt.getString("Rank");
			shadowdogs = nbt.getDouble("shadowdogs");
			shadowzombies = nbt.getDouble("shadowzombies");
			shadowskeletons = nbt.getDouble("shadowskeletons");
			shadowhorses = nbt.getDouble("shadowhorses");
			maxshadows = nbt.getDouble("maxshadows");
			mpregencooldown = nbt.getDouble("mpregencooldown");
			miningmastery = nbt.getDouble("miningmastery");
			miningmcxp = nbt.getDouble("miningmcxp");
			miningmnxp = nbt.getDouble("miningmnxp");
			SwordMastery = nbt.getDouble("SwordMastery");
			swordcxp = nbt.getDouble("swordcxp");
			swordnxp = nbt.getDouble("swordnxp");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.IsPlayer = message.data.IsPlayer;
					variables.DebugMode = message.data.DebugMode;
					variables.nxp = message.data.nxp;
					variables.cxp = message.data.cxp;
					variables.level = message.data.level;
					variables.currentstamina = message.data.currentstamina;
					variables.maxstamina = message.data.maxstamina;
					variables.slot1ability = message.data.slot1ability;
					variables.slot2ability = message.data.slot2ability;
					variables.slot3ability = message.data.slot3ability;
					variables.ultimateslot = message.data.ultimateslot;
					variables.fatigue = message.data.fatigue;
					variables.currentfatigue = message.data.currentfatigue;
					variables.Strength = message.data.Strength;
					variables.vitality = message.data.vitality;
					variables.Intelligence = message.data.Intelligence;
					variables.agility = message.data.agility;
					variables.name = message.data.name;
					variables.Title = message.data.Title;
					variables.Job = message.data.Job;
					variables.statpoints = message.data.statpoints;
					variables.Rank = message.data.Rank;
					variables.shadowdogs = message.data.shadowdogs;
					variables.shadowzombies = message.data.shadowzombies;
					variables.shadowskeletons = message.data.shadowskeletons;
					variables.shadowhorses = message.data.shadowhorses;
					variables.maxshadows = message.data.maxshadows;
					variables.mpregencooldown = message.data.mpregencooldown;
					variables.miningmastery = message.data.miningmastery;
					variables.miningmcxp = message.data.miningmcxp;
					variables.miningmnxp = message.data.miningmnxp;
					variables.SwordMastery = message.data.SwordMastery;
					variables.swordcxp = message.data.swordcxp;
					variables.swordnxp = message.data.swordnxp;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
