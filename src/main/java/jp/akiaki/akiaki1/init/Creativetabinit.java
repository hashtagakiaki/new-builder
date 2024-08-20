package jp.akiaki.akiaki1.init;


import jp.akiaki.akiaki1.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;

public class Creativetabinit {
        public static final List<Supplier<? extends ItemLike>> EXAMPLE_TAB_ITEMS = new ArrayList<>();
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

        public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
                        () -> CreativeModeTab.builder()
                                        .withTabsBefore(CreativeModeTabs.COMBAT)
                                        .icon(() -> Iteminit.EXAMPLE_ITEM.get().getDefaultInstance())
                                        .displayItems((parameters, output) -> 
                                                EXAMPLE_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                                        .build());

        public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        EXAMPLE_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
