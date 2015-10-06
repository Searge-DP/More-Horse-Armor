package net.epoxide.mha;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.epoxide.mha.addon.Addon;
import net.epoxide.mha.addon.metallurgy.AddonMetallurgy;
import net.epoxide.mha.common.ProxyCommon;
import net.epoxide.mha.item.MHAItems;
import net.epoxide.mha.util.Constants;

import java.util.ArrayList;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, guiFactory = Constants.FACTORY, dependencies = "required-after:bookshelf")
public class MoreHorseArmor {

    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;

    @Mod.Instance(Constants.MOD_ID)
    public static MoreHorseArmor instance;
    private ArrayList<Addon> addonList = new ArrayList<Addon>();

    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        proxy.registerSidedEvents();

        new MHAItems();

        if (Loader.isModLoaded("Metallurgy")) {

            addonList.add(new AddonMetallurgy());
        }

        for (Addon addon : addonList)
            addon.preInit();
    }

    @EventHandler
    public void init (FMLInitializationEvent event) {

        for (Addon addon : addonList)
            addon.init();
    }

    @EventHandler
    public void postInit (FMLPostInitializationEvent event) {

        for (Addon addon : addonList)
            addon.postInit();
    }

}