package com.x29naybla.paleolib.block.entity;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> SUSPICIOUS_ROCK = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PaleoLib.MOD_ID);

    public static final Supplier<BlockEntityType<ChiselableBlockEntity>> CHISELABLE =  SUSPICIOUS_ROCK.register("chiselable",
            () -> BlockEntityType.Builder.of(ChiselableBlockEntity::new,
                            ModBlocks.SUSPICIOUS_ANDESITE.get(),
                            ModBlocks.SUSPICIOUS_BASALT.get(),
                            ModBlocks.SUSPICIOUS_BLACKSTONE.get(),
                            ModBlocks.SUSPICIOUS_CALCITE.get(),
                            ModBlocks.SUSPICIOUS_DEEPSLATE.get(),
                            ModBlocks.SUSPICIOUS_DIORITE.get(),
                            ModBlocks.SUSPICIOUS_DRIPSTONE_BLOCK.get(),
                            ModBlocks.SUSPICIOUS_END_STONE.get(),
                            ModBlocks.SUSPICIOUS_GRANITE.get(),
                            ModBlocks.SUSPICIOUS_RED_SANDSTONE.get(),
                            ModBlocks.SUSPICIOUS_SANDSTONE.get(),
                            ModBlocks.SUSPICIOUS_STONE.get(),
                            ModBlocks.SUSPICIOUS_TUFF.get())
                            .build(null));
}
