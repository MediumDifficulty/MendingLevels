package yes.mediumdifficulty.mendinglevels.mixin;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import yes.mediumdifficulty.mendinglevels.config.ConfigManager;

@Mixin(Enchantments.class)
public class EnchantmentsMixin {
    @ModifyArg(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/MendingEnchantment;<init>(Lnet/minecraft/enchantment/Enchantment$Rarity;[Lnet/minecraft/entity/EquipmentSlot;)V"),
            index = 0
    )
    private static Enchantment.Rarity registerMendingInjection(Enchantment.Rarity weight) {
        return ConfigManager.RARITY;
    }
}
