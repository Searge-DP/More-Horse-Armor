package net.epoxide.mha.addon;

import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.epoxide.mha.item.HorseArmorTier;
import net.epoxide.mha.item.ItemHorseArmorBase;
import net.epoxide.mha.item.ItemManager;

public class AddonBotania {
    
    public AddonBotania() {
        
        addHorseArmor(new HorseArmorTier("terrasteel", 6, "Botania:manaResource#4"));
        addHorseArmor(new HorseArmorTier("elementium", 5, "Botania:manaResource#7"));
        addHorseArmor(new HorseArmorTier("terrasteel", 6, "Botania:manaResource#0"));
    }
    
    public void addHorseArmor(HorseArmorTier tier) {
        
        MHAConfigurationHandler.configureArmorTier(tier);
        tier.setItem(new ItemHorseArmorBase(tier));
        ItemManager.addTierRecipe(tier);
    }
}
