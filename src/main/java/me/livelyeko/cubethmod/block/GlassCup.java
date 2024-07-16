package me.livelyeko.cubethmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GlassCup extends Block {

    public GlassCup(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5,11, 11, 11);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        if(player.isCreative())
        {
            player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
        } else {
            player.playSound(SoundEvents.BLOCK_GLASS_PLACE, 1.0f, 1.0f);
        }

        return super.onBreak(world, pos, state, player);
    }
}
