package net.epoxide.mha;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.epoxide.mha.addon.AddonBotania;
import net.epoxide.mha.common.ProxyCommon;
import net.epoxide.mha.handler.MHAConfigurationHandler;
import net.epoxide.mha.item.ItemManager;
import net.epoxide.mha.util.Constants;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION, guiFactory = Constants.FACTORY, dependencies = "required-after:bookshelf;after:Botania")
public class MoreHorseArmor {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static MoreHorseArmor instance;
    
    public static CreativeTabs tabHorseArmor = new CreativeTabHorseArmor();
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        new MHAConfigurationHandler(event.getSuggestedConfigurationFile());
        ItemManager.initItems();
        
        if (Loader.isModLoaded("Botania"))
            new AddonBotania();
    }
}