package yes.mediumdifficulty.mendinglevels.mixin;

import net.minecraft.world.item.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import yes.mediumdifficulty.mendinglevels.config.ConfigManager;


@Mixin(MendingEnchantment.class)
public class MendingEnchantmentMixin {
    /**
     * @author Calamitous_End
     * @reason fix mending not appearing up in enchantment table.
     */
    @Overwrite
    public int getMinPower(final int level) {
        return 7 + (level - 1) * 10;
    }
    /**
     * @author Calamitous_End
     * @reason fix mending not appearing in enchantment table.
     */
    @Overwrite
    public int getMaxPower(final int level) {
        return this.getMinPower(level) + 50;
    }
    /**
     * @author Calamitous_End
     * @reason overwrites max mending level.
     */
    @Overwrite
    public int getMaxLevel() {
        return ConfigManager.MAX_LEVEL;
    }
    /**
     * @author Calamitous_End
     * @reason determines whether mending can show up in enchantment table.
     */
    @Overwrite
    public boolean isTreasureOnly() {
        return ConfigManager.IS_TREASURE;
    }
}
