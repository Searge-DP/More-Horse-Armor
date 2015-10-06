package net.epoxide.mha.addon.metallurgy;

import net.darkhax.bookshelf.items.ItemHorseArmor;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorMetallurgy extends ItemHorseArmor {

    @Override
    public int getArmorValue (EntityHorse horse, ItemStack stack) {

        return 0;
    }

    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {

    }

    @Override
    public String getArmorTexture (EntityHorse horse, ItemStack stack) {

        return null;
    }

    @Override
    public void onArmorRendering (EntityHorse entity, ItemStack stack, RendererLivingEntity renderer, double posX, double posY, double posZ, int flag) {

    }
}
