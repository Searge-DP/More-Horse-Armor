package net.epoxide.mha.item;

import net.darkhax.bookshelf.items.ItemHorseArmor;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorFlying extends ItemHorseArmor {

    public ItemHorseArmorFlying () {

        this.setUnlocalizedName("horseArmorFlying");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public int getArmorValue (EntityHorse horse, ItemStack stack) {

        return 10;
    }

    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {

    }

    @Override
    public String getArmorTexture (EntityHorse horse, ItemStack stack) {

        return "textures/entity/horse/armor/horse_armor_iron.png";
    }

    @Override
    public void onArmorRendering (EntityHorse entity, ItemStack stack, RendererLivingEntity renderer, double posX, double posY, double posZ, int flag) {

    }
}
