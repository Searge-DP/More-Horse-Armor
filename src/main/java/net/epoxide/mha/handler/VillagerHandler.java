package net.epoxide.mha.handler;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipeList;

public class VillagerHandler {
    
    public VillagerHandler() {
        
        if (MHAConfigurationHandler.allowVillager) {
            
            VillagerRegistry reg = VillagerRegistry.instance();
            reg.registerVillagerId(MHAConfigurationHandler.villagerID);
            reg.registerVillageTradeHandler(MHAConfigurationHandler.villagerID, new VillageTradeHandler());
            
            if (FMLCommonHandler.instance().getSide().equals(Side.CLIENT))
                reg.registerVillagerSkin(MHAConfigurationHandler.villagerID, new ResourceLocation("morehorsearmor:textures/mob/rancher.png"));
        }
    }
    
    public class VillageTradeHandler implements VillagerRegistry.IVillageTradeHandler {
        
        @Override
        public void manipulateTradesForVillager (EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        
        }
    }
}