package yes.mediumdifficulty.mendinglevels;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yes.mediumdifficulty.mendinglevels.config.SimpleConfig;

public class MendingLevels implements ModInitializer {
    public static Logger LOGGER = LoggerFactory.getLogger("MendingLevels");
    public static SimpleConfig CONFIG = SimpleConfig.of("mendinglevels").provider(MendingLevels::configProvider).request();
    public static int MAX_LEVEL = MendingLevels.CONFIG.getOrDefault("max_level", 5);

    @Override
    public void onInitialize() {
        LOGGER.info("I has loaded!");
    }

    private static String configProvider(String fileName) {
        return
                """
                #The maximum mending level
                #(you can effectively disable the mod by setting it to 1, but I have no idea why you would do that seen as you've downloaded this mod to change the max value)
                max_level=5
                """;
    }
}
