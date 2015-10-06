package net.epoxide.mha.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.epoxide.mha.util.Constants;
import net.minecraft.item.Item;

public class MHAItems {

    public static Item itemHorseArmorFlying = registerItem("horseArmorFlying", new ItemHorseArmorFlying());

    public static Item registerItem (String name, Item item) {

        return GameRegistry.registerItem(item, name, Constants.MOD_ID);
    }
}
