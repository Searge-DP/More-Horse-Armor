package net.epoxide.mha.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.darkhax.bookshelf.util.Utilities;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemManager {
    public static final Item itemHorseArmorFlying = addTierRecipe(new ItemHorseArmorFlying("flying", 11), "");
    public static final Item itemHorseArmorFlame = addTierRecipe(new ItemHorseArmorFlame("flame", 11), "");
    public static final Item itemHorseArmorNature = addTierRecipe(new ItemHorseArmorNature("nature", 11), "");

    public ItemManager () {

    }

    /**
     * Adds a new crafting using a HorseArmorTier. This makes use of string names, and uses the
     * typical crafting recipe model.
     *
     * @param tier: The tier to add the crafting recipe for.
     */
    public static void addTierRecipe (HorseArmorTier tier) {

        Object material = Utilities.getThingByName(tier.getRecipeItemName());

        if (tier.isEnabled() && material != null)
            GameRegistry.addShapedRecipe(new ItemStack(tier.getItem()), "  x", "xyx", "xxx", Character.valueOf('x'), material, Character.valueOf('y'), Items.leather);
    }

    public static Item addTierRecipe (ItemHorseArmorBase armorBase, String item) {

        System.out.println(Item.itemRegistry.getKeys());
        Object material = Utilities.getThingByName(item);

        if (material != null)
            GameRegistry.addShapedRecipe(new ItemStack(armorBase), "  x", "xyx", "xxx", Character.valueOf('x'), material, Character.valueOf('y'), Items.leather);

        return armorBase;
    }

    public static Item addTierRecipe (ItemHorseArmorBase armorBase, ItemStack item) {

        if (item != null)
            GameRegistry.addShapedRecipe(new ItemStack(armorBase), "  x", "xyx", "xxx", Character.valueOf('x'), item, Character.valueOf('y'), Items.leather);

        return armorBase;
    }
}