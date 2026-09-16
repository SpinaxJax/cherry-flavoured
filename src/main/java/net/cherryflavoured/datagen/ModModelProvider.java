package net.cherryflavoured.datagen;

import net.cherryflavoured.block.ModBlocks;
import net.cherryflavoured.item.ModArmorMaterials;
import net.cherryflavoured.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {

        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.SILVER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.SILVER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.SILVER_SWORD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateSpear(ModItems.SILVER_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_SHOVEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_PICKAXE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_AXE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_HOE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateTrimmableItem(ModItems.SILVER_HELMET, ModArmorMaterials.SILVER_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SILVER_CHESTPLATE, ModArmorMaterials.SILVER_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SILVER_LEGGINGS, ModArmorMaterials.SILVER_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.SILVER_BOOTS, ModArmorMaterials.SILVER_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);



    }
}