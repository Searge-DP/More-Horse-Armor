package net.epoxide.mha;

import net.epoxide.mha.item.ItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabHorseArmor extends CreativeTabs {
    
    public CreativeTabHorseArmor() {
        
        super("horseArmor");
    }
    
    @Override
    public Item getTabIconItem () {
        
        return ItemManager.flame;
    }
}