package tfar.simplenpcs.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import tfar.simplenpcs.client.SkinModel;

public class HumaniodEntity extends AbstractHumanoidEntity {


    public HumaniodEntity(EntityType<? extends SimpleNPCEntity> entityType, Level level, Enum<?> variant) {
        super(entityType, level, SkinModel.HUMANOID,variant);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5F)
                .add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.ATTACK_DAMAGE, 0.0D);
    }
}
