package jp.akiaki.akiaki1.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;

public class Builder_location_card extends Item {
    public BlockPos copypos;

    public Builder_location_card(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        // builderじゃなきゃPosコピー
        if (!BuiltInRegistries.BLOCK.getKey(context.getLevel().getBlockState(context.getClickedPos()).getBlock())
                .toString().equals("akiaki1:builder")) {
            copypos = context.getClickedPos();
        }
        return super.useOn(context);
    }
}
