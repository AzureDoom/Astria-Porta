package mod.azure.astriaporta;

import mod.azure.astriaporta.util.APBlocks;
import mod.azure.astriaporta.util.APEntityTypes;
import mod.azure.astriaporta.util.APItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(AstriaPortaMod.MODID)
public class AstriaPortaMod {

	public static AstriaPortaMod instance;
	public static final String MODID = "astriaporta";

	public AstriaPortaMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::enqueueIMC);
		modEventBus.addListener(this::processIMC);
		MinecraftForge.EVENT_BUS.register(this);
		APEntityTypes.TILE_TYPES.register(modEventBus);
		APItems.ITEMS.register(modEventBus);
		APBlocks.BLOCKS.register(modEventBus);
		GeckoLib.initialize();
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			// register GlobalEntityTypeAttributes here
		});
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}

	private void processIMC(final InterModProcessEvent event) {

	}

	public static final ItemGroup AstriaPortaItemGroup = (new ItemGroup("astriaporta") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(APItems.CHEVRON_GATE_BLOCK.get());
		}
	});
}
