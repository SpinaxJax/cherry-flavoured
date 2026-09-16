package net.cherryflavoured.datagen;

import net.cherryflavoured.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTypeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(EntityTypeTags.UNDEAD);
        tag(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES);

        tag(ModTags.EntityTypes.SENSITIVE_TO_SILVER)
                .addTag(EntityTypeTags.UNDEAD)
                .addTag(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES);

    }
}
