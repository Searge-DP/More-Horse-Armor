package net.epoxide.mha;

import java.util.HashMap;

import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.epoxide.mha.item.HorseArmorTier;
import net.epoxide.mha.item.ItemHorseArmorBase;
import net.epoxide.mha.item.ItemManager;

//TODO move to other mod.
public class MetallurgyItems {
    
    /**
     * Map of all metallurgy horse armor tiers.
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
        
        for (HorseArmorTier tier : MetallurgyItems.sets.values()) {
            
            MHAConfigurationHandler.configureArmorTier(tier);
            tier.setItem(new ItemHorseArmorBase(tier));
            ItemManager.addTierRecipe(tier);
        }
    }
    
    /**
     * Adds a new armor tier to the map of sets added by this addon.
     * 
     * @param name: The name for this set, should be all lower cased with no spaces or
     *            underscores.
     * @param protection: The amount of protection this tier should have by default.
     * @param recipeItem: The ID for the item/block used for crafting this armor.
     */
    public void addArmorTier (String name, int protection, String recipeItem) {
        
        String prefix = "metallurgy.";
        sets.put(prefix + name, new HorseArmorTier(prefix + name, protection, recipeItem));
    }
}
