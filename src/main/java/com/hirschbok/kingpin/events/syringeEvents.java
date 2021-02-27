package com.hirschbok.kingpin.events;

import com.hirschbok.kingpin.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.PotionColorCalculationEvent;

@Mod.EventBusSubscriber(modid = "kingpin", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class syringeEvents {

    @SubscribeEvent
    public static void syringeHitSpeed(PlayerInteractEvent.EntityInteract event){
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.SYRINGE.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity)  event.getTarget();
                LivingEntity player =  event.getPlayer();
                player.swingArm(Hand.MAIN_HAND);
                target.addPotionEffect(new EffectInstance(Effects.SPEED, 10 * 20, 3));
            }
        }
    }

    @SubscribeEvent
    public static void syringeInjectSpeed(PlayerInteractEvent.RightClickItem event){
        LivingEntity player = event.getEntityLiving();
        if((player.getHeldItemMainhand().getItem() == RegistryHandler.SYRINGE.get()) && player.isCrouching()){
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10*20, 3));
        }
    }
}
