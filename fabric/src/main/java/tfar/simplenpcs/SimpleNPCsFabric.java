package tfar.simplenpcs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import tfar.simplenpcs.entity.SimpleNPCEntity;

public class SimpleNPCsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.
        // Use Fabric to bootstrap the Common mod.
        SimpleNPCs.init();
        Registry.register(BuiltInRegistries.ENTITY_TYPE,new ResourceLocation(Constants.MOD_ID,"slim_humanoid"),Constants.SLIM_HUMANOID);
        Registry.register(BuiltInRegistries.ENTITY_TYPE,new ResourceLocation(Constants.MOD_ID,"humanoid"),Constants.HUMANOID);

        FabricDefaultAttributeRegistry.register(Constants.HUMANOID, SimpleNPCEntity.createNPCAttributes());
        FabricDefaultAttributeRegistry.register(Constants.SLIM_HUMANOID, SimpleNPCEntity.createNPCAttributes());

    }
}
