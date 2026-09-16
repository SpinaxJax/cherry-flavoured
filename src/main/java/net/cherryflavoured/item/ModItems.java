package net.cherryflavoured.item;

import net.cherryflavoured.CherryFlavoured;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {

    //INGREDIENTS

    public static final Item SILVER_NUGGET = registerItem("silver_nugget", Item::new);
    public static final Item RAW_SILVER = registerItem("raw_silver", Item::new);
    public static final Item SILVER_INGOT = registerItem("silver_ingot", Item::new);

    //TOOLS

    public static final Item SILVER_SPEAR = registerItem("silver_spear",
            properties -> new Item(properties.spear(ModToolMaterials.SILVER, 0.95f, 0.7f, 0.7f, 3.5f, 13.0f, 8.5f, 5.1f, 13.75f, 4.6f)));
    public static final Item SILVER_SWORD = registerItem("silver_sword",
            properties -> new Item(properties.sword(ModToolMaterials.SILVER, 3.0f, -2.4f)));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.SILVER, 1.0f, -2.8f)));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel",
            properties -> new ShovelItem(ModToolMaterials.SILVER, 1.5f, -3f, properties));
    public static final Item SILVER_AXE = registerItem("silver_axe",
            properties -> new AxeItem(ModToolMaterials.SILVER, 6f, -3.2f, properties));
    public static final Item SILVER_HOE = registerItem("silver_hoe",
            properties -> new HoeItem(ModToolMaterials.SILVER, 0f, -3f, properties));

    //ARMORS

    public static final Item SILVER_HELMET = registerItem("silver_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item SILVER_BOOTS = registerItem("silver_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorType.BOOTS)));



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CherryFlavoured.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CherryFlavoured.MOD_ID, name)))));
    }

    public static void registerModItems() {
        CherryFlavoured.LOGGER.info("Registering Mod Items for " + CherryFlavoured.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.insertAfter(Items.IRON_NUGGET,
                    new ItemStack(SILVER_NUGGET));
            output.insertAfter(Items.IRON_INGOT,
                    new ItemStack(SILVER_INGOT));
            output.insertAfter(Items.RAW_IRON,
                    new ItemStack(RAW_SILVER));
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.insertAfter(Items.IRON_PICKAXE,
                    new ItemStack(SILVER_PICKAXE));
            output.insertAfter(Items.IRON_SHOVEL,
                    new ItemStack(SILVER_SHOVEL));
            output.insertAfter(Items.IRON_HOE,
                    new ItemStack(SILVER_HOE));
            output.insertAfter(Items.IRON_AXE,
                    new ItemStack(SILVER_AXE));
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.insertAfter(Items.IRON_SWORD,
                    new ItemStack(SILVER_SWORD));
            output.insertAfter(Items.IRON_SPEAR,
                    new ItemStack(SILVER_SPEAR));
            output.insertAfter(Items.IRON_AXE,
                    new ItemStack(SILVER_AXE));
            output.insertAfter(Items.IRON_BOOTS,
                    new ItemStack(SILVER_HELMET),
                    new ItemStack(SILVER_CHESTPLATE),
                    new ItemStack(SILVER_LEGGINGS),
                    new ItemStack(SILVER_BOOTS));
        });
    }
    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

}