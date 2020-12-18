package mod.azure.astriaporta.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.astriaporta.client.model.GateModel;
import mod.azure.astriaporta.entities.tileentities.GateEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class GateRender extends GeoBlockRenderer<GateEntity> {
	public GateRender(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn, new GateModel());
	}

	@Override
	public RenderType getRenderType(GateEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}