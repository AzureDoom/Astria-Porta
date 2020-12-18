package mod.azure.astriaporta.util;

import mod.azure.astriaporta.AstriaPortaMod;
import mod.azure.astriaporta.blocks.BaseGateBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class APBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			AstriaPortaMod.MODID);

	public static final RegistryObject<Block> BASE_GATE_BLOCK = BLOCKS.register("base_gate_block",
			() -> new BaseGateBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F)
					.sound(SoundType.METAL).notSolid())));

	public static final RegistryObject<Block> CHEVRON_GATE_BLOCK = BLOCKS.register("chevron_gate_block",
			() -> new Block((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F)
					.sound(SoundType.METAL))));
}