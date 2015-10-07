package net.epoxide.mha;

import com.teammetallurgy.metallurgy.api.IMetalSet;
import com.teammetallurgy.metallurgy.api.MetallurgyApi;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.epoxide.mha.common.ProxyCommon;
import net.epoxide.mha.util.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, guiFactory = Constants.FACTORY, dependencies = "required-after:bookshelf;required-after:Metallurgy")
public class MoreHorseArmor {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static MoreHorseArmor instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
    
    }
    
    @EventHandler
    public void init (FMLInitializationEvent event) {
    
    }
    
    @EventHandler
    public void postInit (FMLPostInitializationEvent event) {
        
        String quote = "\"";
        for (String setName : MetallurgyApi.getSetNames()) {
            
            if (!setName.equals("utility")) {
                
                System.out.println(setName);
                IMetalSet set = MetallurgyApi.getMetalSet(setName);
                
                for (String tierName : set.getMetalNames()) {
                    
                    ItemStack legs = set.getLeggings(tierName);
                    ItemStack ingot = set.getIngot(tierName);
                    
                    if (legs != null && ingot != null && legs.getItem() != null && ingot.getItem() != null) {
                        
                        String eName = tierName.toLowerCase().replaceAll("\\s+", "");
                        int ePortection = ((ItemArmor) legs.getItem()).damageReduceAmount;
                        String recipeItem = Item.itemRegistry.getNameForObject(ingot.getItem());
                        
                        System.out.println("addArmorTier (" + quote + eName + quote + ", " + ePortection + ", " + quote + recipeItem + quote + "),");
                    }
                }
            }
        }
    }
}