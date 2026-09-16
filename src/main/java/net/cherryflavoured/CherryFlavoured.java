package net.cherryflavoured;

import net.cherryflavoured.block.ModBlocks;
import net.cherryflavoured.effect.SilverSanctuary;
import net.cherryflavoured.item.ModItems;
import net.cherryflavoured.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CherryFlavoured implements ModInitializer {
	public static final String MOD_ID = "cherry-flavoured";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);;

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		SilverSanctuary.register();

		ModWorldGeneration.generateModWorldGen();


	}
}