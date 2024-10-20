package jp.akiaki.akiaki1.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

import org.jetbrains.annotations.NotNull;

import jp.akiaki.akiaki1.blockentity.Builder_blockentity;
import jp.akiaki.akiaki1.init.Blockentityinit;
import jp.akiaki.akiaki1.item.Builder_location_card;

public class Builder extends Block implements EntityBlock {
    public static BlockPos copypos1;
    public static BlockPos copypos2;

    public Builder(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return Blockentityinit.BUILDER_BLOCKENTITY.get().create(pos, state);
    }

    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
            @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof Builder_blockentity
                    && player.getMainHandItem().getItem().toString() == "builder_location_card") {
                // カードから座標情報の読み取り
                if (player.getMainHandItem().getItem() instanceof Builder_location_card card) {
                    copypos1 = card.copypos1;
                    copypos2 = card.copypos2;
                }
                // ブロックの設置

            }
        }
        return super.use(state, level, pos, player, hand, hitResult);

    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
  return type == MyBlockEntityTypes.MYBE.get() ? Builder_blockentityf::tick : null;
}

}