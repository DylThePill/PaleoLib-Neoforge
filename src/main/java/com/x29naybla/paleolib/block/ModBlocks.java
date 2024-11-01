package com.x29naybla.paleolib.block;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.block.custom.ChiselableBlock;
import com.x29naybla.paleolib.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PaleoLib.MOD_ID);

    public static final DeferredBlock<Block> SUSPICIOUS_STONE = registerBlock("suspicious_stone",
            () -> new ChiselableBlock(Blocks.STONE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_DEEPSLATE = registerBlock("suspicious_deepslate",
            () -> new ChiselableBlock(Blocks.DEEPSLATE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).destroyTime(1.5f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_GRANITE = registerBlock("suspicious_granite",
            () -> new ChiselableBlock(Blocks.GRANITE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_ANDESITE = registerBlock("suspicious_andesite",
            () -> new ChiselableBlock(Blocks.ANDESITE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_DIORITE = registerBlock("suspicious_diorite",
            () -> new ChiselableBlock(Blocks.DIORITE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_TUFF = registerBlock("suspicious_tuff",
            () -> new ChiselableBlock(Blocks.TUFF, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_DRIPSTONE_BLOCK = registerBlock("suspicious_dripstone_block",
            () -> new ChiselableBlock(Blocks.DRIPSTONE_BLOCK, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).destroyTime(0.75f).explosionResistance(0.5f)));

    public static final DeferredBlock<Block> SUSPICIOUS_CALCITE = registerBlock("suspicious_calcite",
            () -> new ChiselableBlock(Blocks.CALCITE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).destroyTime(0.375f).explosionResistance(0.375f)));

    public static final DeferredBlock<Block> SUSPICIOUS_SANDSTONE = registerBlock("suspicious_sandstone",
            () -> new ChiselableBlock(Blocks.SANDSTONE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).destroyTime(0.4f).explosionResistance(0.4f)));

    public static final DeferredBlock<Block> SUSPICIOUS_RED_SANDSTONE = registerBlock("suspicious_red_sandstone",
            () -> new ChiselableBlock(Blocks.RED_SANDSTONE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).destroyTime(0.4f).explosionResistance(0.4f)));

    public static final DeferredBlock<Block> SUSPICIOUS_BLACKSTONE = registerBlock("suspicious_blackstone",
            () -> new ChiselableBlock(Blocks.BLACKSTONE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).destroyTime(0.75f).explosionResistance(3)));

    public static final DeferredBlock<Block> SUSPICIOUS_BASALT = registerBlock("suspicious_basalt",
            () -> new ChiselableBlock(Blocks.BASALT, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).destroyTime(0.625f).explosionResistance(2.1f)));

    public static final DeferredBlock<Block> SUSPICIOUS_END_STONE = registerBlock("suspicious_end_stone",
            () -> new ChiselableBlock(Blocks.END_STONE, SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_SAND_COMPLETED,BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).destroyTime(1.5f).explosionResistance(4.5f)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
