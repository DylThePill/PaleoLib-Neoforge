package com.x29naybla.paleolib.datagen;

import com.x29naybla.paleolib.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get(),1)
                .pattern("I")
                .pattern("C")
                .pattern("S")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(recipeOutput);
    }
}
