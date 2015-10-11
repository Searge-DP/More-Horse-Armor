package net.epoxide.mha.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemManager {
    
    // public static final Item itemHorseArmorFlying = addTierRecipe(new
    // ItemHorseArmorFlying("flying", 11), "");
    // public static final Item itemHorseArmorFlame = addTierRecipe(new
    // ItemHorseArmorFlame("flame", 11), "");
    // public static final Item itemHorseArmorNature = addTierRecipe(new
    // ItemHorseArmorNature("nature", 11), "");
    
    public ItemManager() {
    
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