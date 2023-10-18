package tfar.simplenpcs.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.core.UUIDUtil;
import tfar.simplenpcs.Constants;
import tfar.simplenpcs.client.render.HumanoidRenderer;
import tfar.simplenpcs.client.render.SlimHumanoidRenderer;

import java.util.Arrays;
import java.util.UUID;

public class SimpleNPCsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Constants.HUMANOID, HumanoidRenderer::new);
        EntityRendererRegistry.register(Constants.SLIM_HUMANOID, SlimHumanoidRenderer::new);
        System.out.println(Arrays.toString(UUIDUtil.uuidToIntArray(UUID.fromString("ec70bcaf-702f-4bb8-b48d-276fa52a780c"))));
    }

    ///summon simplenpcs:humanoid ~ ~ ~ {"SkinData":{"SkinUUID":ec70bcaf-702f-4bb8-b48d-276fa52a780c}}

    ///summon simplenpcs:humanoid ~ ~ ~ {"SkinData":{"SkinUUID":[I;-328155985, 1882147768, -1265817745, -1523943412]}}

}
