package net.epoxide.mha.handler;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.epoxide.mha.item.ItemHorseArmorBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class HorseHandler {

    @SubscribeEvent
    public void onHorseHit (LivingHurtEvent event) {

        if (event.entity instanceof EntityHorse && (event.source.getDamageType().equals("player") || event.source.getDamageType().equals("player"))) {
            EntityHorse entityHorse = (EntityHorse) event.entity;

            AnimalChest chest = ObfuscationReflectionHelper.getPrivateValue(EntityHorse.class, entityHorse, "horseChest", "");
            ItemStack armor = chest.getStackInSlot(1);
            if (armor.getItem() instanceof ItemHorseArmorBase) {
                event.setCanceled(((ItemHorseArmorBase) armor.getItem()).damage(entityHorse, event.ammount, event.source.getEntity()));
            }
        }

    }

    @SubscribeEvent
    public void onTooltipDisplayed(ItemTooltipEvent event) {

        if (event.itemStack != null && event.itemStack.getItem() != null)
            event.toolTip.add("Name: " + Item.itemRegistry.getNameForObject(event.itemStack.getItem()));
    }
}
