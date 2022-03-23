package yes.mediumdifficulty.mendinglevels;

import net.fabricmc.api.ModInitializer;
import yes.mediumdifficulty.mendinglevels.config.SimpleConfig;

public class MendingLevels implements ModInitializer {
    public static SimpleConfig CONFIG = SimpleConfig.of("mendinglevels").provider(MendingLevels::configProvider).request();
    public static int MAX_LEVEL = MendingLevels.CONFIG.getOrDefault("max_level", 5);

    @Override
    public void onInitialize() {
        System.out.println("Loaded Mending Levels!");
    }

    private static String configProvider(String fileName) {
        return
                "#The maximum mending level\n" +
                "#(you can effectively disable the mod by setting it to 1, but I have no idea why you would do that seen as you've downloaded this mod to change the max value)\n" +
                "max_level=5\n";
    }
}
