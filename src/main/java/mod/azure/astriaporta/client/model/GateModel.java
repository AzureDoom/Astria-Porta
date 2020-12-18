package mod.azure.astriaporta.client.model;

import mod.azure.astriaporta.AstriaPortaMod;
import mod.azure.astriaporta.entities.tileentities.GateEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GateModel extends AnimatedGeoModel<GateEntity> {

	public GateModel() {
	}

	@Override
	public ResourceLocation getModelLocation(GateEntity object) {
		return new ResourceLocation(AstriaPortaMod.MODID, "geo/stargate.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(GateEntity object) {
		return new ResourceLocation(AstriaPortaMod.MODID, "textures/blocks/stargate.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(GateEntity object) {
		return new ResourceLocation(AstriaPortaMod.MODID, "animations/stargate.animation.json");
	}
}