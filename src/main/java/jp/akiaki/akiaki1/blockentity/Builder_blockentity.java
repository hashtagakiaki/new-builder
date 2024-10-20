package jp.akiaki.akiaki1.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import jp.akiaki.akiaki1.init.Blockentityinit;

public class Builder_blockentity extends BlockEntity  implements BlockEntityTicker<Builder_blockentity>{
    public Builder_blockentity(BlockPos p_155229_, BlockState p_155230_) {
        super(Blockentityinit.BUILDER_BLOCKENTITY.get(), p_155229_, p_155230_);
    }

    public void load(CompoundTag nbt) {
        super.load(nbt);

        System.out.println(nbt);
    }

    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, Builder_blockentity p_155256_) {
        System.out.println("a");
    }
}
