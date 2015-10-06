package net.epoxide.mha.addon.metallurgy;

import com.teammetallurgy.metallurgy.api.IMetalSet;
import com.teammetallurgy.metallurgy.api.MetallurgyApi;
import net.epoxide.mha.addon.Addon;
import net.minecraft.item.Item;

import java.util.HashMap;

public class AddonMetallurgy extends Addon {

    private HashMap<String, Item> metalArmor = new HashMap<String, Item>();

    @Override
    public void postInit () {

        for (String setName : MetallurgyApi.getSetNames()) {
            IMetalSet metalSet = MetallurgyApi.getMetalSet(setName);
            String[] metalNames = metalSet.getMetalNames();

            for (String metal : metalNames) {

            }
        }

        //        MHAItems.registerItem()
    }
}
