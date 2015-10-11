package net.epoxide.mha.addon;

import net.epoxide.mha.item.HorseArmorTier;
import net.epoxide.mha.item.ItemManager;

public class AddonBotania {
    
    public AddonBotania() {
        
        ItemManager.initTieredHorseArmor(new HorseArmorTier("terrasteel", 6, "Botania:manaResource#4"));
        ItemManager.initTieredHorseArmor(new HorseArmorTier("elementium", 5, "Botania:manaResource#7"));
        ItemManager.initTieredHorseArmor(new HorseArmorTier("manasteel", 6, "Botania:manaResource#0"));
    }
}
