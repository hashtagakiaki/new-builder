package jp.akiaki.akiaki1.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

import org.jetbrains.annotations.NotNull;

import jp.akiaki.akiaki1.blockentity.Builder_blockentity;
import jp.akiaki.akiaki1.init.Blockentityinit;
import jp.akiaki.akiaki1.item.Builder_location_card;
import org.jetbrains.annotations.Nullable;

public class Builder extends Block implements EntityBlock {
    public Builder(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return Blockentityinit.BUILDER_BLOCKENTITY.get().create(pos, state);
    }

    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                          @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof Builder_blockentity be) {
            be.use_builder(state, level, pos, player, hand, hitResult);
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }
}