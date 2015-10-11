package net.epoxide.mha.addon;

import net.darkhax.bookshelf.util.Utilities;
import net.epoxide.mha.item.ItemManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AddonBotania {
    public static Item itemHorseArmorTerrasteel = ItemManager.addTierRecipe(new ItemHorseArmorTerrasteel("terrasteel", 6), new ItemStack((Item) Item.itemRegistry.getObject("Botania:manaResource"), 1, 4));
    public static Item itemHorseArmorElementium = ItemManager.addTierRecipe(new ItemHorseArmorTerrasteel("elementium", 5), new ItemStack((Item) Item.itemRegistry.getObject("Botania:manaResource"), 1, 7));
    public static Item itemHorseArmorManasteel = ItemManager.addTierRecipe(new ItemHorseArmorTerrasteel("manasteel", 5), "Botania:manaResource");
}
