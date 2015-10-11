package net.epoxide.mha.item;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ItemHorseArmorNature extends ItemHorseArmorBase {
    
    int tick = 0;
    
    public ItemHorseArmorNature(String name, int armorPoints) {
        
        super(name, armorPoints);
    }
    
    @Override
    public void onHorseUpdate (EntityHorse horse, ItemStack stack) {
        
        if (horse.riddenByEntity instanceof EntityPlayer) {
            // 5 seconds
            if (tick == 20 * 5) {
                EntityPlayer entityPlayer = (EntityPlayer) horse.riddenByEntity;
                World world = horse.worldObj;
                int x = (int) horse.posX;
                int y = (int) horse.posY - 1;
                int z = (int) horse.posZ;
                Block block = world.getBlock(x, y, z);
                BonemealEvent event = new BonemealEvent(entityPlayer, world, block, x, y, z);
                if (MinecraftForge.EVENT_BUS.post(event))
                    return;
                    
                if (block instanceof IGrowable) {
                    IGrowable igrowable = (IGrowable) block;
                    if (igrowable.func_149851_a(world, x, y, z, world.isRemote)) {
                        if (!world.isRemote) {
                            if (igrowable.func_149852_a(world, world.rand, x, y, z)) {
                                igrowable.func_149853_b(world, world.rand, x, y, z);
                            }
                        }
                    }
                }
                tick = 0;
            }
            
            tick++;
        }
    }
}
