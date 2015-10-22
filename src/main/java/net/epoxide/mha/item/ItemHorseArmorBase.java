package net.epoxide.mha.item;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.bookshelf.items.ItemHorseArmor;
import net.darkhax.bookshelf.util.Utilities;
import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class ItemHorseArmorBase extends ItemHorseArmor {
    
    /**
     * The name used in the unlocalized name, item id and texture path of the item.
     */
    private String name;
    
    /**
     * A version of the armor name which is guaranteed to not have dots in it. Used for texture
     * paths.
     */
    private String propperName;
    
    /**
     * The amount of protection offered by this piece of armor.
     */
    private int armorPoints;
    
    /**
     * Constructs a basic piece of horse armor using a HorseArmorTier.
     *
     * @param tier: The Tier to use when constructing this Item.
     */
    public ItemHorseArmorBase(HorseArmorTier tier) {
        
        this(tier.getTierName(), tier.getProtectionAmount());
        tier.setProtectionAmount(this.armorPoints);
    }
    
    /**
     * Constructs a basic piece of horse armor. The only customizable properties are the name,
     * texture and armor points.
     *
     * @param name: A name to use for this piece of armor. Used in unlocalized name, item id,
     *            and texture path.
     * @param armorPoints: The amount of protection this piece of armor should provide. Iron is
     *            5, gold is 7 and diamond is 11.
     */
    public ItemHorseArmorBase(String name, int armorPoints) {
        
        this.name = name;
        this.propperName = name.replaceAll("[.]", "_");
        this.armorPoints = MHAConfigurationHandler.configureArmorPoints(name, armorPoints);
        this.setUnlocalizedName("mha." + name);
        this.setTextureName("morehorsearmor:" + propperName + "_horse_armor");
        this.setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(this, "armor_" + propperName);
    }
    
    @Override
    public int getArmorValue (EntityHorse horse, ItemStack stack) {
        
        int nbtArmor = checkArmorNBT(stack);
        return nbtArmor > 0 ? nbtArmor : this.armorPoints;
    }
    
    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {
    
    }
    
    @Override
    public boolean onHorseDamaged (EntityHorse horse, ItemStack stack, DamageSource source, float damage) {
        
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture (EntityHorse horse, ItemStack stack) {
        
        return "morehorsearmor:textures/entity/horse/armor/horse_armor_" + this.propperName + ".png";
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void onArmorRendering (EntityHorse entity, ItemStack stack, RendererLivingEntity renderer, double posX, double posY, double posZ, int flag) {
    
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer reader, List tip, boolean isDebug) {
        
        tip.add(StatCollector.translateToLocal("tooltip.morehorsearmor.protection") + ": " + this.armorPoints);
    }
    
    /**
     * Checks an ItemStack for a custom armor value written in it's NBT. Allows for HorseArmor
     * to be given a special armor value from NBT.
     *
     * @param stack: The ItemStack to check for armor values in NBT.
     * @return int: The armor value for this item. If the armor does not have a custom armor
     *         value, -1 will be given. 0 May also be given in odd and nearly impossible
     *         situations.
     */
    public static int checkArmorNBT (ItemStack stack) {
        
        Utilities.prepareDataTag(stack);
        NBTTagCompound dataTag = stack.getTagCompound();
        return dataTag.hasKey("armorValue") ? dataTag.getInteger("armorValue") : -1;
    }
}