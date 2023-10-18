package tfar.simplenpcs.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.SkullBlockEntity;

import javax.annotation.Nullable;

public class SimpleNPCEntity extends Mob {


    // Synced entity data
    public static final EntityDataAccessor<String> CLIENT_GAMEPROFILE =
            SynchedEntityData.defineId(SimpleNPCEntity.class, EntityDataSerializers.STRING);

    @Nullable
    private GameProfile gameProfile;

    protected SimpleNPCEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createNPCAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0).add(Attributes.ATTACK_KNOCKBACK);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CLIENT_GAMEPROFILE, "");
    }

    public void setGameProfile(@Nullable GameProfile gameProfile) {
        synchronized(this) {
            this.gameProfile = gameProfile;
        }
        this.updateOwnerProfile();
    }

    @Nullable
    public GameProfile getGameProfile() {
        if (gameProfile == null && !entityData.get(CLIENT_GAMEPROFILE).isEmpty()) {
            setGameProfile(new GameProfile(null,entityData.get(CLIENT_GAMEPROFILE)));
        }
        return gameProfile;
    }

    private void updateOwnerProfile() {
        SkullBlockEntity.updateGameprofile(this.gameProfile, (gameProfile) -> {
            this.gameProfile = gameProfile;
        });
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(CLIENT_GAMEPROFILE,tag.getString("SkullOwner"));
        if (!entityData.get(CLIENT_GAMEPROFILE).isEmpty()) {
            setGameProfile(new GameProfile(null, tag.getString("SkullOwner")));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("SkullOwner", entityData.get(CLIENT_GAMEPROFILE));
    }
}
