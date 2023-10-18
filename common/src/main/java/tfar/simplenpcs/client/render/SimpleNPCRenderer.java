package tfar.simplenpcs.client.render;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.core.UUIDUtil;
import net.minecraft.resources.ResourceLocation;
import tfar.simplenpcs.entity.SimpleNPCEntity;

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

        Minecraft minecraft = Minecraft.getInstance();
        GameProfile profile = entity.getGameProfile();

        if (profile == null) return getDefaultTexture();

        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.getSkinManager().getInsecureSkinInformation(profile);
        return map.containsKey(MinecraftProfileTexture.Type.SKIN) ? minecraft.getSkinManager()
                .registerTexture(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN) :
                DefaultPlayerSkin.getDefaultSkin(UUIDUtil.getOrCreatePlayerUUID(profile));

    }
}
