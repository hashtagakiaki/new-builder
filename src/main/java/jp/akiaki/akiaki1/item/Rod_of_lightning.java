package jp.akiaki.akiaki1.item;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.network.chat.Component;

public class Rod_of_lightning extends Item {
    public Rod_of_lightning(Item.Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        LightningBolt lightningBolt = (LightningBolt) EntityType.LIGHTNING_BOLT.create(level);
        lightningBolt.setPos(player.getPosition(0));
        level.addFreshEntity(lightningBolt);
        BlockHitResult ray = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        BlockPos lookPos = ray.getBlockPos();
        BlockState blockState = level.getBlockState(lookPos);
        System.out.println(blockState);
        return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        context.getLevel().setBlock(context.getClickedPos(), Blocks.DIRT.defaultBlockState(), 1);
        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player
                    .sendSystemMessage(Component.literal(String.valueOf(context.getPlayer().getX())));
        }
        return super.useOn(context);
    }
}
