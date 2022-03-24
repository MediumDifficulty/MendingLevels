package yes.mediumdifficulty.mendinglevels.mixin;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
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

    @ModifyArg(
            method = "<init>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;<init>(Lnet/minecraft/enchantment/Enchantment$Rarity;Lnet/minecraft/enchantment/EnchantmentTarget;[Lnet/minecraft/entity/EquipmentSlot;)V"),
            index = 0
    )
    private static Enchantment.Rarity constructorRarityInjection(Enchantment.Rarity weight) {
        return ConfigManager.RARITY;
    }
}
