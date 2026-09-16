package net.cherryflavoured.datagen;

import net.cherryflavoured.block.ModBlocks;
import net.cherryflavoured.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER, ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE);

                oreSmelting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SILVER_INGOT, .25f, 200, "silver");
                oreBlasting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SILVER_INGOT, .25f, 100, "silver");


                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_SILVER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_SILVER_BLOCK);

                shapeless(RecipeCategory.MISC, ModItems.RAW_SILVER, 9)
                        .requires(ModBlocks.RAW_SILVER_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_SILVER_BLOCK), has(ModBlocks.RAW_SILVER_BLOCK))
                        .group("silver")
                        .save(output, "raw_silver_from_raw_silver_block");

                shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT, 9)
                        .requires(ModBlocks.SILVER_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK), has(ModBlocks.SILVER_BLOCK))
                        .group("silver")
                        .save(output, "silver_ingot_from_silver_block");

                shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET, 9)
                        .requires(ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .group("silver")
                        .save(output);

                shaped(RecipeCategory.TOOLS,ModItems.SILVER_PICKAXE)
                        .pattern("III")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);
                shaped(RecipeCategory.TOOLS,ModItems.SILVER_AXE)
                        .pattern("II")
                        .pattern("SI")
                        .pattern("S ")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);
                shaped(RecipeCategory.TOOLS,ModItems.SILVER_SHOVEL)
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);
                shaped(RecipeCategory.TOOLS,ModItems.SILVER_HOE)
                        .pattern("II")
                        .pattern("S ")
                        .pattern("S ")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);
                shaped(RecipeCategory.COMBAT,ModItems.SILVER_SWORD)
                        .pattern("I")
                        .pattern("I")
                        .pattern("S")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);
                shaped(RecipeCategory.COMBAT,ModItems.SILVER_SPEAR)
                        .pattern("  I")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('S', Items.STICK)
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT,ModItems.SILVER_HELMET)
                        .pattern("III")
                        .pattern("I I")
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .group("silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT,ModItems.SILVER_CHESTPLATE)
                        .pattern("I I")
                        .pattern("III")
                        .pattern("III")
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .group("silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT,ModItems.SILVER_LEGGINGS)
                        .pattern("III")
                        .pattern("I I")
                        .pattern("I I")
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .group("silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT,ModItems.SILVER_BOOTS)
                        .pattern("I I")
                        .pattern("I I")
                        .define('I', ModItems.SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT), has(ModItems.SILVER_INGOT))
                        .group("silver")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "Cherry Flavoured Recipes!";
    }
}
