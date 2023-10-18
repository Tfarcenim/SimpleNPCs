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
       // System.out.println(Arrays.toString(UUIDUtil.uuidToIntArray(UUID.fromString("ec70bcaf-702f-4bb8-b48d-276fa52a780c"))));
    }

    ///summon simplenpcs:humanoid ~ ~ ~ {"SkinData":{"SkinUUID":ec70bcaf-702f-4bb8-b48d-276fa52a780c}}

    ///summon simplenpcs:humanoid ~ ~ ~ {SkullOwner:Dream}

    //summon simplenpcs:humanoid ~ ~ ~ {SkullOwner: {Id: [I; -328155985, 1882147768, -1265817745, -1523943412], Properties: {textures: [{Value: "ewogICJ0aW1lc3RhbXAiIDogMTY5NzUzMjgxMzU5NywKICAicHJvZmlsZUlkIiA6ICJlYzcwYmNhZjcwMmY0YmI4YjQ4ZDI3NmZhNTJhNzgwYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJEcmVhbSIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jYTkzZjZmYzQwNDg4ZjE4NzdjZGE5NGE4MzBiNTRlOWY2ZjU0YWI1OGE1NDUzYmFkNWM5NDc3MjZkZDFmNDczIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=", Signature: "Gl/pAp6efZUwhir2t7Psgk9yT3YuNVoqAnfpTH7suSNw313iksS+YAgVu1SRcfCjmkNxElE8R8NSa0rg/F1SAK31vg1O6s9bhM5TG4AFwTHY5j2YzgghEW/dDN/DbxGZia2kHukY6l635fpcQe5xVx1GfArz6NbrqyD7DE4kdWm5CshZ5YMTpD9G3aRX0EyfrPLz2DnU4RTok3eosbIfXVL7A4KejBnlxRIikqMil8eLwtHE+6KHbhIUBXvcKOZqp1N7xmgqNgk/86FM2YixsxPXoiLmTxASDTG1Mkg1igd6am/KXfafUe9t1BAzmfxOWxvJudaR70Y0psfglsAYek7LLFkiJCaabsZ+Dw/uvr4jFA7stzcKYbCgJ/IOuwMqtv1vSs0Zf8xZGP6JAfcplHX2GDjcxyrhr6NfyTkhOv7Z52mAbaCNB13TuTqy76Jr1CLpYlw6gwRJwoFi3yhVhkUUnQq94k+9zjfnk3zezjMMdgd+zU5OfXlujW9h2XVBdvm9pF5E/JebtBQcvB0TJ7ny0gxNpk9RfuNKQM25Xp0iiSPOdFPStHW+aV/YOc/xiFZz0oPagcIFFsYDGpeJBPRYmpjrVKEPf05bC9ucVNrZm2oL924OMY74wy6JG9xO4JdZ9uCbwWETGdP75fVhf/AzBpt6PnybdYmTBvsz1cI="}]}, Name: "Dream"}}}

    ///summon simplenpcs:humanoid ~ ~ ~ {"SkinData":{"SkinUUID":[I;-328155985, 1882147768, -1265817745, -1523943412]}}

}
