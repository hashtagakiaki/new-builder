package jp.akiaki.akiaki1.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import jp.akiaki.akiaki1.init.Blockentityinit;

public class Builder_blockentity extends BlockEntity{
    public Builder_blockentity(BlockPos p_155229_, BlockState p_155230_) {
        super(Blockentityinit.BUILDER_BLOCKENTITY.get(), p_155229_, p_155230_);
    }
    public void load(CompoundTag nbt) {
        super.load(nbt);

        System.out.println(nbt);
    }
}
