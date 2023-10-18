package tfar.simplenpcs.client.render;

import net.minecraft.Util;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import tfar.simplenpcs.client.PlayerTextureManager;
import tfar.simplenpcs.entity.SimpleNPCEntity;
import tfar.simplenpcs.entity.SlimHumaniodEntity;

import java.util.EnumMap;
import java.util.Map;

public abstract class SimpleNPCRenderer<T extends SimpleNPCEntity,S extends PlayerModel<T>> extends MobRenderer<T,S> {


    public SimpleNPCRenderer(EntityRendererProvider.Context $$0, S $$1, float $$2) {
        super($$0, $$1, $$2);
    }

    @Override
    public ResourceLocation getTextureLocation(SimpleNPCEntity entity) {
        return this.getEntityPlayerTexture(entity);
    }

    ResourceLocation getEntityPlayerTexture(SimpleNPCEntity entity) {
                return getPlayerTexture(entity);
    }

    public abstract ResourceLocation getDefaultTexture();

    ResourceLocation getPlayerTexture(SimpleNPCEntity entity) {
        return PlayerTextureManager.getOrCreateTextureWithDefault(entity, getDefaultTexture());
    }
}
