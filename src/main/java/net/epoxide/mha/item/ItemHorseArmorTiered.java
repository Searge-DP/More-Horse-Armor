package net.epoxide.mha.item;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorTiered extends ItemHorseArmorBase {
    
    /**
     * The tier used to generate a piece of horse armor.
     */
    private HorseArmorTier tier;
    
    /**
     * Constructs a new ItemHorseArmorTiered. This is an extension of ItemHorseArmorBase that
     * makes use of HorseArmorTier instead of raw values.
     * 
     * @param tier: The HorseArmorTier to use for this horse armor.
     */
    public ItemHorseArmorTiered(HorseArmorTier tier) {
        
        super(tier.getTierName(), tier.getProtectionAmount());
        this.tier = tier;
    }
    
    @Override
    public int getArmorValue (EntityHorse horse, ItemStack stack) {
        
        int nbtArmor = checkArmorNBT(stack);
        return nbtArmor > 0 ? nbtArmor : this.tier.getProtectionAmount();
    }
}