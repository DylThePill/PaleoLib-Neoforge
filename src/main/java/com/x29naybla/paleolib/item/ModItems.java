package com.x29naybla.paleolib.item;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PaleoLib.MOD_ID);

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().stacksTo(1).durability(64)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
