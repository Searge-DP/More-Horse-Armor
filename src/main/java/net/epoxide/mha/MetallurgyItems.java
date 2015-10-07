package net.epoxide.mha;

import java.util.HashMap;

import net.epoxide.mha.item.HorseArmorTier;
import net.minecraftforge.common.config.Configuration;

public class MetallurgyItems {
    
    /**
     * 
     */
    public static HashMap<String, HorseArmorTier> sets = new HashMap();
    
    public MetallurgyItems() {
        
        // Base
        addArmorTier("copper", 2, "Metallurgy:copper.ingot");
        addArmorTier("bronze", 3, "Metallurgy:bronze.ingot");
        addArmorTier("hepatizon", 3, "Metallurgy:hepatizon.ingot");
        addArmorTier("damascussteel", 5, "Metallurgy:damascus.steel.ingot");
        addArmorTier("angmallen", 5, "Metallurgy:angmallen.ingot");
        addArmorTier("steel", 5, "Metallurgy:steel.ingot");
        
        // Ender
        addArmorTier("eximite", 5, "Metallurgy:eximite.ingot");
        addArmorTier("desichalkos", 5, "Metallurgy:desichalkos.ingot");
        
        // Fantasy
        addArmorTier("prometheum", 2, "Metallurgy:prometheum.ingot");
        addArmorTier("deepiron", 5, "Metallurgy:deep.iron.ingot");
        addArmorTier("blacksteel", 5, "Metallurgy:black.steel.ingot");
        addArmorTier("oureclase", 5, "Metallurgy:oureclase.ingot");
        addArmorTier("astralsilver", 5, "Metallurgy:astral.silver.ingot");
        addArmorTier("carmot", 5, "Metallurgy:carmot.ingot");
        addArmorTier("mithril", 5, "Metallurgy:mithril.ingot");
        addArmorTier("quicksilver", 5, "Metallurgy:quicksilver.ingot");
        addArmorTier("haderoth", 5, "Metallurgy:haderoth.ingot");
        addArmorTier("orichalcum", 6, "Metallurgy:orichalcum.ingot");
        addArmorTier("celenegil", 6, "Metallurgy:celenegil.ingot");
        addArmorTier("adamantine", 6, "Metallurgy:adamantine.ingot");
        addArmorTier("atlarus", 6, "Metallurgy:atlarus.ingot");
        addArmorTier("tartarite", 6, "Metallurgy:tartarite.ingot");
        
        // Nether
        addArmorTier("ignatius", 5, "Metallurgy:ignatius.ingot");
        addArmorTier("shadowiron", 5, "Metallurgy:shadow.iron.ingot");
        addArmorTier("midasium", 3, "Metallurgy:midasium.ingot");
        addArmorTier("vyroxeres", 5, "Metallurgy:vyroxeres.ingot");
        addArmorTier("ceruclase", 5, "Metallurgy:ceruclase.ingot");
        addArmorTier("kalendrite", 5, "Metallurgy:kalendrite.ingot");
        addArmorTier("vulcanite", 6, "Metallurgy:vulcanite.ingot");
        addArmorTier("sanguinite", 6, "Metallurgy:sanguinite.ingot");
        addArmorTier("shadowsteel", 5, "Metallurgy:shadow.steel.ingot");
        addArmorTier("inolashite", 5, "Metallurgy:inolashite.ingot");
        addArmorTier("amordrine", 5, "Metallurgy:amordrine.ingot");
        
        // Precious
        addArmorTier("silver", 3, "Metallurgy:silver.ingot");
        addArmorTier("platinum", 5, "Metallurgy:platinum.ingot");
        addArmorTier("brass", 2, "Metallurgy:brass.ingot");
        addArmorTier("electrum", 5, "Metallurgy:electrum.ingot");
    }
    
    /**
     * 
     * @param name
     * @param protection
     * @param recipeItem
     */
    public void addArmorTier (String name, int protection, String recipeItem) {
        
        sets.put(name, new HorseArmorTier(name, protection, recipeItem));
    }
    
    public void syncConfig (Configuration cfg) {
        
        for (HorseArmorTier entry : sets.values()) {
            
            String tierName = entry.getTierName();
            entry.setEnabled(cfg.getBoolean(tierName + "Enabled", "Armor Accessibility", true, "If set to false, the " + tierName + " horse armor will not be added to the game. Changes made through the config GUI require a restart to take effect."));
            entry.setProtectionAmount(cfg.getInt(tierName + "Armor", "Armor Values", entry.getProtectionAmount(), 0, Integer.MAX_VALUE, "The amount of protection provided by a piece of " + tierName + " horse armor. Can be changed while the game is running through config GUI."));
            entry.setRecipeItemName(cfg.getString(tierName + "RepairItem", "Repair Items", entry.getRecipeItemName(), "The String based item ID for the item used to craft this set of armor. Changes made through the config GUI require a restart to take effect."));
        }
    }
}
