package net.epoxide.mha.item;

import net.darkhax.bookshelf.items.ItemHorseArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

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

        return "mha:textures/entity/horse/armor/horse_armor_grayscale.png";
    }

    @Override
    public void onArmorRendering (EntityHorse entity, ItemStack stack, RendererLivingEntity renderer, double posX, double posY, double posZ, int flag) {

        ModelHorseOverlay overlay = new ModelHorseOverlay();

        if (flag == 0) {
            GL11.glPushMatrix();
            float r = 180f / 255f;
            float g = 144f / 255f;
            float b = 90f / 255f;
            GL11.glColor4f(r, g, b, 1f);
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(getArmorTexture(entity, stack)));
            overlay.render(entity, (float) posX, (float) posY, (float) posZ, 0, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("mha:textures/entity/horse/armor/horse_armor_oak.png"));
            overlay.render(entity, (float) posX, (float) posY, (float) posZ, 0, 0, 0);

            GL11.glPopMatrix();
        }

    }

    private float getColor (int x) {

        return x / 255;
    }
}
