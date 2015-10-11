package net.epoxide.mha.addon;

import net.epoxide.mha.item.ItemManager;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class AddonBotania {
    Item itemHorseArmorTerrasteel = ItemManager.addTierRecipe(new ItemHorseArmorTerrasteel("terrasteel", 6), OreDictionary.getOres("ingotTerrasteel").get(0));
    Item itemHorseArmorElementium = ItemManager.addTierRecipe(new ItemHorseArmorTerrasteel("elementium", 5), OreDictionary.getOres("ingotElvenElementium").get(0));

    public AddonBotania () {

    }
}