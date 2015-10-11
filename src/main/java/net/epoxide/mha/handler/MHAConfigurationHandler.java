package net.epoxide.mha.handler;

import java.io.File;

import net.epoxide.mha.item.HorseArmorTier;
import net.minecraftforge.common.config.Configuration;

public class MHAConfigurationHandler {
    
    /**
     * A representation of the physical configuration file on the hard drive.
     */
    public static Configuration config;
    
    /**
     * Should our new villager spawn?
     */
    public static boolean allowVillager = true;
    
    /**
     * The ID for the new villager.
     */
    public static int villagerID = 89725;
    
    public MHAConfigurationHandler(File configFile) {
        
        config = new Configuration(configFile);
        
        allowVillager = config.getBoolean("allowVillager", "Villager", allowVillager, "Should the rancher villager spawn?");
        villagerID = config.getInt("villagerID", "Villager", villagerID, Integer.MIN_VALUE, Integer.MAX_VALUE, "What id should the villager use?");
        
        if (config.hasChanged())
            config.save();
    }
    
    /**
     * Runs a HorseArmorTier through the configuration file. This will update all fields with
     * the options that have been set in the configuration file. If the tier is not found in
     * the configuration file already, it will be appended. New configuration entries can be
     * found in the config file for this mod.
     * 
     * @param tier: The tier to synchronize with the configuration file.
     */
    public static void configureArmorTier (HorseArmorTier tier) {
        
        String tierName = tier.getTierName();
        tier.setEnabled(config.getBoolean(tierName + "Enabled", "Armor Accessibility", true, "If set to false, the " + tierName + " horse armor will not be added to the game."));
        tier.setProtectionAmount(config.getInt(tierName + "Armor", "Armor Values", tier.getProtectionAmount(), 0, Integer.MAX_VALUE, "The amount of protection provided by a piece of " + tierName + " horse armor."));
        tier.setRecipeString(config.getString(tierName + "RepairItem", "Repair Items", tier.getRecipeString(), "The String based item ID for the item used to craft this set of armor."));
        
        if (config.hasChanged())
            config.save();
    }
}