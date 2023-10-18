package tfar.simplenpcs.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import tfar.simplenpcs.client.SkinModel;

public class AbstractHumanoidEntity extends SimpleNPCEntity {

    // Skin Details
    public enum Variant {
        ALEX, ARI, EFE, KAI, MAKENA, NOOR, STEVE, SUNNY, ZURI,
    }
    protected AbstractHumanoidEntity(EntityType<? extends Mob> entityType, Level level, SkinModel skinModel, Enum<?> variant) {
        super(entityType, level, skinModel, variant);
    }
}
