package jp.akiaki.akiaki1.init;

import jp.akiaki.akiaki1.ExampleMod;
import jp.akiaki.akiaki1.blockentity.Builder_blockentity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blockentityinit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITYS = DeferredRegister
                        .create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MODID);
    public static final RegistryObject<BlockEntityType<Builder_blockentity>> BUILDER_BLOCKENTITY = BLOCKENTITYS
                        .register("mybe", () -> BlockEntityType.Builder.of(Builder_blockentity::new, Blockinit.BUILDER.get())
                                        .build(null));
}
