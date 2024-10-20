package jp.akiaki.akiaki1.init;

import jp.akiaki.akiaki1.item.Builder_location_card;
import jp.akiaki.akiaki1.item.Rod_of_lightning;
import jp.akiaki.akiaki1.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import static jp.akiaki.akiaki1.init.Creativetabinit.addToTab;;

public class Iteminit {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        ExampleMod.MODID);

        public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = addToTab(ITEMS.register("example_block",
                        () -> new BlockItem(Blockinit.EXAMPLE_BLOCK.get(), new Item.Properties())));

        public static final RegistryObject<Item> EXAMPLE_ITEM = addToTab(ITEMS.register("example_item",
                        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                                        .alwaysEat().nutrition(1).saturationMod(2f).build()))));

        public static final RegistryObject<Item> TIMEITEM = addToTab(ITEMS.register("rodoflightning",
                        () -> new Rod_of_lightning(new Item.Properties())));

        public static final RegistryObject<Item> BUILDER_ITEM = addToTab(ITEMS.register("builder",
                        () -> new BlockItem(Blockinit.BUILDER.get(), new Item.Properties())));
        public static final RegistryObject<Item> BUILDER_CARD = addToTab(
                        ITEMS.register("builder_location_card",
                                        () -> new Builder_location_card(new Item.Properties())));
}
