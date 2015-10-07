package net.epoxide.mha.item;

public class HorseArmorTier {
    
    /**
     * Should this armor tier be used?
     */
    private boolean isEnabled;
    
    /**
     * The item associated with this tier. This will be null, until the item can be
     * constructed.
     */
    private ItemHorseArmorBase item;
    
    /**
     * The name of this armor tier. No spaces, all lower case.
     */
    private String tierName;
    
    /**
     * A string based ID to use in the crafting recipe for this tier.
     */
    private String recipeItemName;
    
    /**
     * The amount of protection provided by this armor tier.
     */
    private int protectionAmount;
    
    /**
     * Constructs a new HorseArmorTier. HorseArmorTier serves as a wrapper for the tier data,
     * and is primarily used when syncing the configuration data.
     * 
     * @param name: The name of the tier being added. All lower case with no underscores or
     *            spaces is preferred.
     * @param protection: The amount of protection offered by this tier.
     * @param recipeID: The String based ID for the Item/Block to use when crafting this horse
     *            armor.
     */
    public HorseArmorTier(String name, int protection, String recipeID) {
        
        this.isEnabled = true;
        this.tierName = name;
        this.recipeItemName = recipeID;
        this.protectionAmount = protection;
    }
    
    /**
     * Checks if this tier should be used to generate horse armor or not.
     * 
     * @return boolean: If this tier is enabled, true will be returned.
     */
    public boolean isEnabled () {
        
        return isEnabled;
    }
    
    /**
     * Allows for this tier to be enabled or disabled, depending on the passed boolean.
     * 
     * @param isEnabled: Whether or not this armor should be enabled. True to enabled, false to
     *            disable.
     */
    public void setEnabled (boolean isEnabled) {
        
        this.isEnabled = isEnabled;
    }
    
    /**
     * Retrieves the ID for the item/block to use for this armors crafting recipe.
     * 
     * @return String: The ID of the item/block to use in this tiers crafting recipe.
     */
    public String getRecipeItemName () {
        
        return recipeItemName;
    }
    
    /**
     * Sets the ID to use for this tiers crafting recipe.
     * 
     * @param recipeItemName: The new ID to use for this tiers recipe.
     */
    public void setRecipeItemName (String recipeItemName) {
        
        this.recipeItemName = recipeItemName;
    }
    
    /**
     * Retrieves the protection value offered by this tiers armor.
     * 
     * @return int: The amount of armor points provided by this tiers armor.
     */
    public int getProtectionAmount () {
        
        return protectionAmount;
    }
    
    /**
     * Sets the protection value for this tiers armor.
     * 
     * @param protectionAmount: The new protection amount for this armor.
     */
    public void setProtectionAmount (int protectionAmount) {
        
        this.protectionAmount = protectionAmount;
    }
    
    /**
     * Retrieves the name of this armor tier.
     * 
     * @return String: The name of the armor tier.
     */
    public String getTierName () {
        
        return this.tierName;
    }
    
    /**
     * Retrieves the ItemHorseArmorBase associated with this armor tier. This will be null
     * until the Item can construct. This will be after the tier is constructed, and after the
     * configuration file has a chance to sync.
     * 
     * @return ItemHorseArmorBase: The item associated with this armor tier.
     */
    public ItemHorseArmorBase getItem () {
        
        return item;
    }
    
    /**
     * Sets the ItemHorseArmorBase associated with this armor tier. This should only be used
     * when you first construct the Item related to this tier.
     * 
     * @param item: The item associated with this armor tier.
     */
    public void setItem (ItemHorseArmorBase item) {
        
        this.item = item;
    }
}
