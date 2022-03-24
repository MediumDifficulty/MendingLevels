package yes.mediumdifficulty.mendinglevels.mixin;


import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yes.mediumdifficulty.mendinglevels.config.ConfigManager;

@Mixin(MendingEnchantment.class)
public class MendingEnchantmentMixin {
    @Inject(method = "getMaxLevel", at = @At("RETURN"), cancellable = true)
    private void getMaxLevelInjection(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(ConfigManager.MAX_LEVEL);
    }

    @Inject(method = "isTreasure", at = @At("RETURN"), cancellable = true)
    private void isTreasureInjection(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(ConfigManager.IS_TREASURE);
    }
}
