package com.hirschbok.kingpin.util;

import com.hirschbok.kingpin.items.syringe;
import com.hirschbok.kingpin.kingpin;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, kingpin.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Item> SYRINGE = ITEMS.register("syringe", syringe::new);
     public static final RegistryObject<Item> POPPYRESIN = ITEMS.register("poppyresin", poppyresin::new);
}

