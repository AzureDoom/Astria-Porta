package mod.azure.astriaporta.util;

import mod.azure.astriaporta.AstriaPortaMod;
import mod.azure.astriaporta.entities.tileentities.GateEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class APEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			AstriaPortaMod.MODID);

	public static final DeferredRegister<TileEntityType<?>> TILE_TYPES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, AstriaPortaMod.MODID);

	public static final RegistryObject<TileEntityType<GateEntity>> STARGATE = TILE_TYPES.register("stargate",
			() -> TileEntityType.Builder.<GateEntity>create(GateEntity::new, APBlocks.BASE_GATE_BLOCK.get())
					.build(null));
}