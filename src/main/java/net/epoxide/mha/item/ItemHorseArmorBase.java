package net.epoxide.mha.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.bookshelf.items.ItemHorseArmor;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorBase extends ItemHorseArmor {

    /**
     * The name used in the unlocalized name, item id and texture path of the item.
     */
    private String name;

    /**
     * The amount of protection offered by this piece of armor.
     */
    private int armorPoints;

    /**
     * Constructs a basic piece of horse armor. The only customizable properties are the name,
     * texture and armor points.
     *
     * @param name:        A name to use for this piece of armor. Used in unlocalized name, item id,
     *                     and texture path.
     * @param armorPoints: The amount of protection this piece of armor should provide. Iron is
     *                     5, gold is 7 and diamond is 11.
     */
    public ItemHorseArmorBase (String name, int armorPoints) {

        this.name = name;
        this.armorPoints = armorPoints;
        this.setUnlocalizedName("mha." + name);
        this.setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(this, "armor_" + name);
    }

    @Override
    public int getArmorValue (EntityHorse horse, ItemStack stack) {

        return this.armorPoints;
    }

    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture (EntityHorse horse, ItemStack stack) {

        return "mha:textures/entity/horse/armor/horse_armor_" + this.name + ".png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onArmorRendering (EntityHorse entity, ItemStack stack, RendererLivingEntity renderer, double posX, double posY, double posZ, int flag) {

    }
}