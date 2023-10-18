package tfar.simplenpcs;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfar.simplenpcs.entity.HumaniodEntity;
import tfar.simplenpcs.entity.SlimHumaniodEntity;

public class Constants {

	public static final String MOD_ID = "simplenpcs";
	public static final String MOD_NAME = "SimpleNPCs";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final EntityType<SlimHumaniodEntity> SLIM_HUMANOID = EntityType.Builder.<SlimHumaniodEntity>of(SlimHumaniodEntity::new, MobCategory.MISC)
			.sized(0.6F, 1.8F).clientTrackingRange(32).updateInterval(2).build("slim_humanoid");

	public static final EntityType<HumaniodEntity> HUMANOID = EntityType.Builder.<HumaniodEntity>of(HumaniodEntity::new, MobCategory.MISC)
			.sized(0.6F, 1.8F).clientTrackingRange(32).updateInterval(2).build("humanoid");

}