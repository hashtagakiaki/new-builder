package jp.akiaki.akiaki1.blockentity;

import jp.akiaki.akiaki1.block.Builder;
import jp.akiaki.akiaki1.item.Builder_location_card;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import jp.akiaki.akiaki1.init.Blockentityinit;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Builder_blockentity extends BlockEntity {
    public BlockPos abs_copypos;
    public BlockPos rel_copypos;
    public int counter = 10;

    public Builder_blockentity(BlockPos p_155229_, BlockState p_155230_) {
        super(Blockentityinit.BUILDER_BLOCKENTITY.get(), p_155229_, p_155230_);
    }

    public void load(CompoundTag nbt) {
        super.load(nbt);
    }

    public void builder_builder_place(Level pLevel, BlockPos pPos, BlockState pState) {
        if (abs_copypos != null) {
            pLevel.setBlock(abs_copypos, pState, 2);
            if (pLevel.getBlockEntity(abs_copypos) instanceof Builder_blockentity placed_builder) {
                placed_builder.counter = counter - 1;
                placed_builder.rel_copypos = rel_copypos;
                placed_builder.builder_builder_place(pLevel, pPos, pState);
            }
        }
    }

    public void use_builder(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                            @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof Builder_blockentity
                    && player.getMainHandItem().getItem() instanceof Builder_location_card card) {
                // カードから座標情報の読み取り
                abs_copypos = card.copypos;
                rel_copypos = abs_copypos.subtract(pos);
            } else {
                builder_builder_place(level, pos, state);
            }
        }
    }
}
