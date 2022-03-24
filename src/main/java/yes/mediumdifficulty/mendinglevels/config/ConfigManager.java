package yes.mediumdifficulty.mendinglevels.config;

import net.minecraft.enchantment.Enchantment;

public class ConfigManager {
    public static SimpleConfig CONFIG = SimpleConfig.of("mendinglevels").provider(ConfigManager::configProvider).request();

    public static int MAX_LEVEL = CONFIG.getOrDefault("max_level", 5);
    public static boolean IS_TREASURE = CONFIG.getOrDefault("is_treasure", true);
    public static Enchantment.Rarity RARITY = Enchantment.Rarity.valueOf(CONFIG.getOrDefault("rarity", "RARE"));

    private static String configProvider(String fileName) {
        return
                """
                #The maximum mending level
                #(you can effectively disable the mod by setting it to 1, but I have no idea why you would do that seen as you've downloaded this mod to change the max value)
                max_level=5
                
                
                #EXPERIMENTAL SETTINGS
                
                #If the mending enchantment is treasure (true = can't be in enchanting table)
                is_treasure=true
                
                #Rarity of the mending enchantment
                #Available values: COMMON, UNCOMMON, RARE, VERY_RARE
                rarity=RARE
                """;
    }
}
