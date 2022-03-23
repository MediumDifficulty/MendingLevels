package yes.mediumdifficulty.mendinglevels.mixin;


import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yes.mediumdifficulty.mendinglevels.MendingLevels;

@Mixin(MendingEnchantment.class)
public class MendingEnchantmentMixin {
    @Inject(method = "getMaximumLevel", at = @At("RETURN"), cancellable = true)
    private void getMaxLevelInjection(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(MendingLevels.MAX_LEVEL);
    }
}
