package com.x29naybla.paleolib.event;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.block.entity.ChiselableBlockRenderer;
import com.x29naybla.paleolib.block.entity.ModBlockEntityTypes;
import com.x29naybla.paleolib.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = PaleoLib.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUpEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.CHISELABLE.get(), ChiselableBlockRenderer::new);
        ItemProperties.register(ModItems.CHISEL.get(),
                ResourceLocation.withDefaultNamespace("chiseling"),
                (p_272332_, p_272333_, p_272334_, p_272335_) -> p_272334_ != null && p_272334_.getUseItem() == p_272332_ ? (float) (p_272334_.getUseItemRemainingTicks() % 10) / 10.0F : 0.0F);
    }
}
