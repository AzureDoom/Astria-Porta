package mod.azure.astriaporta.client;

import mod.azure.astriaporta.AstriaPortaMod;
import mod.azure.astriaporta.client.renderer.GateRender;
import mod.azure.astriaporta.util.APEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = AstriaPortaMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(APEntityTypes.STARGATE.get(), GateRender::new);
	}

}
