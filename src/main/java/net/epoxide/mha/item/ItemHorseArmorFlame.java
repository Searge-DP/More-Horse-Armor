package net.epoxide.mha.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.MathHelper;

public class ItemHorseArmorFlame extends ItemHorseArmorBase {
    
    public ItemHorseArmorFlame(String name, int armorPoints) {
        
        super(name, armorPoints);
    }
    
    @Override
    public boolean damage (EntityHorse entityHorse, float amount, Entity attacker) {
        
        attacker.setFire(MathHelper.ceiling_float_int(amount / 2));
        return false;
    }
}
