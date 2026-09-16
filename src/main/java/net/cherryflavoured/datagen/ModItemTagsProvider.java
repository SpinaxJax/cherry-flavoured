package net.cherryflavoured.datagen;

import net.cherryflavoured.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(ModItems.SILVER_SWORD));
        tag(ItemTags.SPEARS)
                .add(ModItems.getRK(ModItems.SILVER_SPEAR));
        tag(ItemTags.AXES)
                .add(ModItems.getRK(ModItems.SILVER_AXE));
        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(ModItems.SILVER_SHOVEL));
        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.SILVER_PICKAXE));
        tag(ItemTags.HOES)
                .add(ModItems.getRK(ModItems.SILVER_HOE));

        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.SILVER_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.SILVER_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.SILVER_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.SILVER_BOOTS));

    }
}
