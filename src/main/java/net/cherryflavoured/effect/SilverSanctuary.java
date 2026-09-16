
package net.cherryflavoured.effect;

import java.util.List;

import net.cherryflavoured.item.ModItems;
import net.cherryflavoured.tags.ModTags;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

public final class SilverSanctuary {
    private static final int TICK_INTERVAL = 15;
    private static final double RADIUS = (double)4.0F;
    private static final float DAMAGE_PER_TICK = 2.0F;

    private    SilverSanctuary() {
    }

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register((ServerTickEvents.EndTick)(server) -> {
            if (server.getTickCount() % TICK_INTERVAL == 0) {
                for(ServerLevel level : server.getAllLevels()) {
                    for(ServerPlayer player : level.players()) {
                        int pieces = countSilverArmor(player);
                        if (pieces != 0) {
                            damageNearbyUndead(level, player, pieces);
                        }
                    }
                }

            }
        });
    }

    private static int countSilverArmor(ServerPlayer player) {
        int count = 0;
        if (isSilverArmor(player.getItemBySlot(EquipmentSlot.HEAD), ModItems.SILVER_HELMET)) {
            ++count;
        }

        if (isSilverArmor(player.getItemBySlot(EquipmentSlot.CHEST), ModItems.SILVER_CHESTPLATE)) {
            ++count;
        }

        if (isSilverArmor(player.getItemBySlot(EquipmentSlot.LEGS), ModItems.SILVER_LEGGINGS)) {
            ++count;
        }

        if (isSilverArmor(player.getItemBySlot(EquipmentSlot.FEET), ModItems.SILVER_BOOTS)) {
            ++count;
        }

        return count;
    }

    private static boolean isSilverArmor(ItemStack stack, Item expected) {
        return !stack.isEmpty() && stack.getItem() == expected;
    }

    private static void damageNearbyUndead(ServerLevel level, ServerPlayer player, int pieces) {
        double radius = RADIUS + (double)(pieces - 1) * (double)0.25F;
        float damage = (float) (DAMAGE_PER_TICK * ((float) pieces / RADIUS));
        AABB box = player.getBoundingBox().inflate(radius);
        List<LivingEntity> undeadList = level.getEntitiesOfClass(LivingEntity.class, box, (entity) -> entity != player && entity.isAlive() && BuiltInRegistries.ENTITY_TYPE.wrapAsHolder(entity.getType()).is(ModTags.EntityTypes.SENSITIVE_TO_SILVER));
        if (!undeadList.isEmpty()) {
            DamageSource damageSource = level.damageSources().magic();

            for(LivingEntity undead : undeadList) {
                if ((double)undead.distanceTo(player) <= radius) {
                    undead.hurtServer(level, damageSource, damage);
                }
            }

        }
    }
}
