package mod.azure.astriaporta.util;

import mod.azure.astriaporta.AstriaPortaMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class APItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			AstriaPortaMod.MODID);

	// BLOCKS
	public static final RegistryObject<Item> BASE_GATE_BLOCK = ITEMS.register("base_gate_block",
			() -> new BlockItem(APBlocks.BASE_GATE_BLOCK.get(),
					new Item.Properties().group(AstriaPortaMod.AstriaPortaItemGroup)));
	public static final RegistryObject<Item> CHEVRON_GATE_BLOCK = ITEMS.register("chevron_gate_block",
			() -> new BlockItem(APBlocks.CHEVRON_GATE_BLOCK.get(),
					new Item.Properties().group(AstriaPortaMod.AstriaPortaItemGroup)));

}