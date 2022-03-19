package yes.mediumdifficulty.mendinglevels.mixin;


import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    private int getMendingRepairAmount(int experienceAmount, int mendingLevel) {
        float finalCalculation = (experienceAmount * (2 + (mendingLevel - 1) / 2f));
//        MendingLevels.LOGGER.info(String.format("experienceAmount: %d, mendingLevel: %d, finalCalculation: %f", experienceAmount, mendingLevel, finalCalculation));
        return (int) finalCalculation;
    }

    private int getMendingRepairCost(int repairAmount, int mendingLevel) {
        float finalCalculation = Math.max(2f * repairAmount / (mendingLevel + 3), 1f);
//        MendingLevels.LOGGER.info(String.format("repairAmount: %d, mendingLevel: %d, finalCalculation: %f", repairAmount, mendingLevel, finalCalculation));
        return (int) finalCalculation;
    }

    private int tempMendingLevel = 0;

    @Inject(
            method = "repairPlayerGears", at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Map$Entry;getValue()Ljava/lang/Object;"),
            locals = LocalCapture.CAPTURE_FAILSOFT
    )
    private void repairPlayerGearsCapture(PlayerEntity player, int amount, CallbackInfoReturnable<Integer> cir, Map.Entry entry) {
        tempMendingLevel = EnchantmentHelper.getLevel(Enchantments.MENDING, (ItemStack) entry.getValue());
    }

    @Redirect(
            method = "repairPlayerGears",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ExperienceOrbEntity;getMendingRepairAmount(I)I")
    )
    private int repairPlayerGearsGetMendingRepairAmountInjection(ExperienceOrbEntity instance, int experienceAmount) {
        return getMendingRepairAmount(experienceAmount, tempMendingLevel);
    }

    @Redirect(
            method = "repairPlayerGears",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ExperienceOrbEntity;getMendingRepairCost(I)I")
    )
    private int repairPlayerGearsGetMendingRepairCostInjection(ExperienceOrbEntity instance, int repairAmount) {
        return getMendingRepairCost(repairAmount, tempMendingLevel);
    }
}
