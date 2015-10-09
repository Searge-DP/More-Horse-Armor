package net.epoxide.mha.item;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemHorseArmorFlame extends ItemHorseArmorBase {

    public ItemHorseArmorFlame (String name, int armorPoints) {

        super(name, armorPoints);
    }

    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {

        if (horse.riddenByEntity instanceof EntityPlayer) {
            horse.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 5, 1));

            if (horse.worldObj.isAirBlock((int) horse.posX, (int) horse.posY, (int) horse.posZ))
                horse.worldObj.setBlock((int) horse.posX, (int) horse.posY, (int) horse.posZ, Blocks.fire);
        }
    }
}
