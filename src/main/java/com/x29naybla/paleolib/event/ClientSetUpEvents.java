package com.x29naybla.paleolib.event;

import com.x29naybla.paleolib.PaleoLib;
import com.x29naybla.paleolib.block.entity.ChiselableBlockRenderer;
import com.x29naybla.paleolib.block.entity.ModBlockEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = PaleoLib.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUpEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.CHISELABLE.get(), ChiselableBlockRenderer::new);
    }
}
