package net.epoxide.mha;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.epoxide.mha.addon.AddonBotania;
import net.epoxide.mha.common.ProxyCommon;
import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.epoxide.mha.item.ItemManager;
import net.epoxide.mha.util.Constants;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, guiFactory = Constants.FACTORY, dependencies = "required-after:bookshelf;after:Botania")
public class MoreHorseArmor {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static MoreHorseArmor instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        if(Loader.isModLoaded("Botania"))
            new AddonBotania();
        
        new ItemManager();
        new MHAConfigurationHandler(event.getSuggestedConfigurationFile());
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @EventHandler
    public void init (FMLInitializationEvent event) {
    
    }
    
    @EventHandler
    public void postInit (FMLPostInitializationEvent event) {
    
    }
    
    @SubscribeEvent
    public void onTooltipDisplayed(ItemTooltipEvent event) {
        
        if (event.itemStack != null && event.itemStack.getItem() != null)
            event.toolTip.add("Name: " + Item.itemRegistry.getNameForObject(event.itemStack.getItem()));
    }
}