package jp.akiaki.akiaki1.init;

import jp.akiaki.akiaki1.ExampleMod;
import jp.akiaki.akiaki1.block.Builder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blockinit {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        ExampleMod.MODID);

        public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
                        () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

        public static final RegistryObject<Builder> BUILDER = BLOCKS.register("builder",
                        () -> new Builder(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

}
