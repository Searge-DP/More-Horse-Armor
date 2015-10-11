package net.epoxide.mha.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorFlying extends ItemHorseArmorBase {
    
    public ItemHorseArmorFlying(String name, int armorPoints) {
        
        super(name, armorPoints);
    }
    
    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {
        
        if (horse.riddenByEntity instanceof EntityPlayer) {
            boolean isJumping = GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump);
            if (isJumping) {
                horse.motionY += 0.15D;
                if (!horse.onGround)
                    horse.fallDistance = 0;
            }
        }
    }
}
