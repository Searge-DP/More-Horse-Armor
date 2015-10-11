package net.epoxide.mha.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class ItemHorseArmorFlame extends ItemHorseArmorBase {
    
    public ItemHorseArmorFlame(String name, int armorPoints) {
        
        super(name, armorPoints);
    }
    
    @Override
    public boolean onHorseDamaged (EntityHorse horse, ItemStack stack, DamageSource source, float damage) {
        
        Entity attacker = source.getEntity();
        
        if (attacker instanceof EntityLivingBase)
            attacker.setFire(MathHelper.ceiling_float_int(damage / 2));
            
        return false;
    }
}
