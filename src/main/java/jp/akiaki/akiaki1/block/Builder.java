package jp.akiaki.akiaki1.block;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import jp.akiaki.akiaki1.init.Blockentityinit;
public class Builder extends Block implements EntityBlock{
    public Builder(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return Blockentityinit.BUILDER_BLOCKENTITY.get().create(pos, state);
    }

}
