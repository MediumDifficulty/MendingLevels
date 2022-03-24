package yes.mediumdifficulty.mendinglevels;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MendingLevels implements ModInitializer {
    public static Logger LOGGER = LoggerFactory.getLogger("MendingLevels");

    @Override
    public void onInitialize() {
        LOGGER.info("Rarity: " + Enchantments.MENDING.getRarity().name());
        LOGGER.info("isTreasure: " + Enchantments.MENDING.isTreasure());
        LOGGER.info("maxLevel: " + Enchantments.MENDING.getMaxLevel());
        LOGGER.info("I has loaded!");
    }
}
