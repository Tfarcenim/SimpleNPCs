package tfar.simplenpcs.client.render;

import net.minecraft.Util;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tfar.simplenpcs.entity.AbstractHumanoidEntity;
import tfar.simplenpcs.entity.SlimHumaniodEntity;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractHumanoidRenderer<T extends AbstractHumanoidEntity,S extends PlayerModel<T>> extends SimpleNPCRenderer<T,S> {
    public AbstractHumanoidRenderer(EntityRendererProvider.Context $$0, S $$1, float $$2) {
        super($$0, $$1, $$2);
    }

    // Variant Textures
    protected static final Map<SlimHumaniodEntity.Variant, ResourceLocation> TEXTURE_BY_VARIANT =
            Util.make(new EnumMap<>(SlimHumaniodEntity.Variant.class), map -> {
                // Build in skins
                map.put(SlimHumaniodEntity.Variant.ALEX, new ResourceLocation("textures/entity/player/wide/alex.png"));
                map.put(SlimHumaniodEntity.Variant.ARI, new ResourceLocation("textures/entity/player/wide/ari.png"));
                map.put(SlimHumaniodEntity.Variant.EFE, new ResourceLocation("textures/entity/player/wide/efe.png"));
                map.put(SlimHumaniodEntity.Variant.KAI, new ResourceLocation("textures/entity/player/wide/kai.png"));
                map.put(SlimHumaniodEntity.Variant.MAKENA, new ResourceLocation("textures/entity/player/wide/makena.png"));
                map.put(SlimHumaniodEntity.Variant.NOOR, new ResourceLocation("textures/entity/player/wide/noor.png"));
                map.put(SlimHumaniodEntity.Variant.STEVE, new ResourceLocation("textures/entity/player/wide/steve.png"));
                map.put(SlimHumaniodEntity.Variant.SUNNY, new ResourceLocation("textures/entity/player/wide/sunny.png"));
                map.put(SlimHumaniodEntity.Variant.ZURI, new ResourceLocation("textures/entity/player/wide/zuri.png"));

            });

}
