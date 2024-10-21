package com.x29naybla.paleolib.item;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PaleoLib.MOD_ID);

    public static final Supplier<CreativeModeTab> PALEOLIB_TAB = CREATIVE_MODE_TAB.register("paleolib_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHISEL.get()))
                    .title(Component.translatable("creativetab.paleolib.paleolib"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHISEL);

                        output.accept(ModBlocks.SUSPICIOUS_STONE);
                        output.accept(ModBlocks.SUSPICIOUS_GRANITE);
                        output.accept(ModBlocks.SUSPICIOUS_DIORITE);
                        output.accept(ModBlocks.SUSPICIOUS_ANDESITE);
                        output.accept(ModBlocks.SUSPICIOUS_CALCITE);
                        output.accept(ModBlocks.SUSPICIOUS_TUFF);
                        output.accept(ModBlocks.SUSPICIOUS_DRIPSTONE_BLOCK);
                        output.accept(ModBlocks.SUSPICIOUS_DEEPSLATE);
                        output.accept(ModBlocks.SUSPICIOUS_SANDSTONE);
                        output.accept(ModBlocks.SUSPICIOUS_RED_SANDSTONE);
                        output.accept(ModBlocks.SUSPICIOUS_BASALT);
                        output.accept(ModBlocks.SUSPICIOUS_BLACKSTONE);
                        output.accept(ModBlocks.SUSPICIOUS_END_STONE);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
