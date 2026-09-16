package net.cherryflavoured.datagen;

import net.cherryflavoured.block.ModBlocks;
import net.cherryflavoured.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider{

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.SILVER_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RAW_SILVER_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.SILVER_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_SILVER_ORE));

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.SILVER_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RAW_SILVER_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.SILVER_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_SILVER_ORE));

        tag(ModTags.Blocks.NEEDS_SILVER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);


        tag(ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);


    }
}