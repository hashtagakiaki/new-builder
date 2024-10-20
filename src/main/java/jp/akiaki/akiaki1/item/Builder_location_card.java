package jp.akiaki.akiaki1.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;

public class Builder_location_card extends Item {
    public BlockPos copypos1;
    public BlockPos copypos2;
    public int flag;

    public Builder_location_card(Item.Properties properties) {
        super(properties);
        flag = 0;
    }

    public InteractionResult useOn(UseOnContext context) {
        // builderじゃなきゃPosコピー
        if (!BuiltInRegistries.BLOCK.getKey(context.getLevel().getBlockState(context.getClickedPos()).getBlock())
                .toString().equals("akiaki1:builder")) {
            if (flag == 0) {
                copypos1 = context.getClickedPos();
                flag = 1;
            }
            if (flag == 1) {
                copypos2 = context.getClickedPos();
                flag = 0;
            }

        }
        return super.useOn(context);
    }
}
