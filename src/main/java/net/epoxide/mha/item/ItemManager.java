package net.epoxide.mha.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemManager {
    
    public ItemManager() {
        
        ItemHorseArmorBase flying = new ItemHorseArmorFlying("flying", 11);
        // TODO flying recipe
        
        ItemHorseArmorBase flame = new ItemHorseArmorFlame("flame", 11);
        // TODO flame recipe
        
        ItemHorseArmorBase nature = new ItemHorseArmorNature("nature", 11);
        // TODO nature recipe
    }
    
    /**
     * Sets up a basic set of armor, based on a HorseArmorTier instance. This will configure
     * the tier to make sure it's fully synced, construct the item and set it to the tier, and
     * add a basic recipe.
     * 
     * @param tier: The HorseArmorTier to initialize and turn into horse armor.
     */
    public static void initTieredHorseArmor (HorseArmorTier tier) {
        
        MHAConfigurationHandler.configureArmorTier(tier);
        tier.setItem(new ItemHorseArmorBase(tier));
        addTierRecipe(tier);
    }
    
    /**
     * Adds a new crafting using a HorseArmorTier. This makes use of string names, and uses the
     * typical crafting recipe model.
     *
     * @param tier: The tier to add the crafting recipe for.
     */
    public static void addTierRecipe (HorseArmorTier tier) {
        
        ItemStack material = tier.getRecipeItem();
        
        if (tier.isEnabled() && material != null)
            GameRegistry.addShapedRecipe(new ItemStack(tier.getItem()), "  x", "xyx", "xxx", Character.valueOf('x'), material, Character.valueOf('y'), Items.leather);
    }
}