package mod.azure.astriaporta.blocks;

import javax.annotation.Nullable;

import mod.azure.astriaporta.entities.tileentities.GateEntity;
import mod.azure.astriaporta.util.APBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BaseGateBlock extends DirectionalBlock {

	@Nullable
	private static BlockPattern gatePatternFull;

	public BaseGateBlock(Properties builder) {
		super(builder);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.create(0f, 0f, 0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		if (BaseGateBlock.getOrCreateGateFull() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new GateEntity();
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof GateEntity) {
			checkGateSpawn(worldIn, pos, (GateEntity) tileentity);
		}
	}

	public static void checkGateSpawn(World worldIn, BlockPos pos, GateEntity tileEntityIn) {
		if (!worldIn.isRemote) {
			Block block = tileEntityIn.getBlockState().getBlock();
			boolean flag = block == APBlocks.BASE_GATE_BLOCK.get() || block == APBlocks.CHEVRON_GATE_BLOCK.get();
			if (flag && pos.getY() >= 3) {
				BlockPattern blockpattern = getOrCreateGateFull();
				BlockPattern.PatternHelper blockpattern$patternhelper = blockpattern.match(worldIn, pos);
				if (blockpattern$patternhelper != null) {
					for (int i = 0; i < blockpattern.getPalmLength(); ++i) {
						for (int j = 0; j < blockpattern.getThumbLength(); ++j) {
							CachedBlockInfo cachedblockinfo = blockpattern$patternhelper.translateOffset(i, j, 0);
							worldIn.playEvent(2001, cachedblockinfo.getPos(),
									Block.getStateId(cachedblockinfo.getBlockState()));
						}
					}
				}
			}
		}
	}

	public static BlockPattern getOrCreateGateFull() {
		if (gatePatternFull == null) {
			gatePatternFull = BlockPatternBuilder.start().aisle("!@!@!", "@###@", "!###!", "@###@", "!@!@!")
					.where('!', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(APBlocks.BASE_GATE_BLOCK.get())))
					.where('@', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(APBlocks.CHEVRON_GATE_BLOCK.get())))
					.where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.AIR))).build();
		}
		return gatePatternFull;
	}

}