package tfar.simplenpcs.entity;

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
import tfar.simplenpcs.Constants;
import tfar.simplenpcs.CustomDataSerializers;
import tfar.simplenpcs.client.SkinModel;
import tfar.simplenpcs.client.SkinType;

import java.util.Optional;
import java.util.UUID;

public class SimpleNPCEntity extends Mob {
    private final SkinModel skinModel;


    // Synced entity data
    public static final EntityDataAccessor<String> DATA_SKIN_NAME =
            SynchedEntityData.defineId(SimpleNPCEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> DATA_SKIN_URL =
            SynchedEntityData.defineId(SimpleNPCEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Optional<UUID>> DATA_SKIN_UUID =
            SynchedEntityData.defineId(SimpleNPCEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    public static final EntityDataAccessor<SkinType> DATA_SKIN_TYPE =
            SynchedEntityData.defineId(SimpleNPCEntity.class, CustomDataSerializers.SKIN_TYPE);

    // CompoundTags
    public static final String DATA_SKIN_DATA_TAG = "SkinData";
    public static final String DATA_SKIN_NAME_TAG = "SkinName";
    public static final String DATA_SKIN_TAG = "Skin";
    public static final String DATA_SKIN_TYPE_TAG = "SkinType";
    public static final String DATA_SKIN_URL_TAG = "SkinURL";
    public static final String DATA_SKIN_UUID_TAG = "SkinUUID";

    protected SimpleNPCEntity(EntityType<? extends Mob> entityType, Level level, SkinModel skinModel, Enum<?> variant) {
        super(entityType, level);
        this.skinModel = skinModel;
    }

    public static AttributeSupplier.Builder createNPCAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0).add(Attributes.ATTACK_KNOCKBACK);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        defineSynchedSkinData();
    }

    void defineSynchedSkinData() {
        entityData.define(DATA_SKIN_NAME, "");
        entityData.define(DATA_SKIN_URL, "");
        entityData.define(DATA_SKIN_UUID, Optional.empty());
        entityData.define(DATA_SKIN_TYPE, SkinType.DEFAULT);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        readAdditionalSkinData(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        addAdditionalSkinData(tag);
    }

    void addAdditionalSkinData(CompoundTag compoundTag) {
        CompoundTag skinTag = new CompoundTag();

        if (this.getSkinName() != null) {
            skinTag.putString(DATA_SKIN_TAG, this.getSkinName());
        }
        if (this.getSkinURL() != null) {
            skinTag.putString(DATA_SKIN_URL_TAG, this.getSkinURL());
        }
        Optional<UUID> skinUUID = this.getSkinUUID();
        if (skinUUID.isPresent()) {
            skinTag.putUUID(DATA_SKIN_UUID_TAG, skinUUID.get());
        }
        if (this.getSkinType() != null) {
            skinTag.putString(DATA_SKIN_TYPE_TAG, this.getSkinType().name());
        }

        compoundTag.put(DATA_SKIN_DATA_TAG, skinTag);
    }

    void readAdditionalSkinData(CompoundTag compoundTag) {

        // Handle legacy skin data
        this.readAdditionalLegacySkinData(compoundTag);

        // Early exit if no skin data is available.
        if (!compoundTag.contains(DATA_SKIN_DATA_TAG)) {
            return;
        }

        // Read skin data
        CompoundTag skinTag = compoundTag.getCompound(DATA_SKIN_DATA_TAG);
        if (skinTag.contains(DATA_SKIN_TYPE_TAG)) {
            String skinType = skinTag.getString(DATA_SKIN_TYPE_TAG);
            if (skinType != null && !skinType.isEmpty()) {
                this.setSkinType(this.getSkinType(skinType));
            }
        }
        if (skinTag.contains(DATA_SKIN_NAME_TAG)) {
            String skinName = skinTag.getString(DATA_SKIN_NAME_TAG);
            if (skinName != null && !skinName.isEmpty()) {
                this.setSkinName(skinName);
            }
        }
        if (skinTag.contains(DATA_SKIN_URL_TAG)) {
            String url = skinTag.getString(DATA_SKIN_URL_TAG);
            if (url != null && !url.isEmpty()) {
                this.setSkinURL(url);
            }
        }
        if (skinTag.contains(DATA_SKIN_UUID_TAG)) {
            UUID skinUUID = skinTag.getUUID(DATA_SKIN_UUID_TAG);
            if (skinUUID != null) {
                this.setSkinUUID(skinUUID);
            }
        }

    }

    void readAdditionalLegacySkinData(CompoundTag compoundTag) {
        if (compoundTag.contains(DATA_SKIN_TYPE_TAG)) {
            Constants.LOG.info("Converting legacy skin data to new format for {}", this);
            String skinType = compoundTag.getString(DATA_SKIN_TYPE_TAG);
            if (skinType != null && !skinType.isEmpty()) {
                this.setSkinType(this.getSkinType(skinType));
            }
            if (compoundTag.contains(DATA_SKIN_TAG)) {
                String skinName = compoundTag.getString(DATA_SKIN_TAG);
                if (skinName != null && !skinName.isEmpty()) {
                    this.setSkinName(skinName);
                }
            }
            if (compoundTag.contains(DATA_SKIN_URL_TAG)) {
                String url = compoundTag.getString(DATA_SKIN_URL_TAG);
                if (url != null && !url.isEmpty()) {
                    this.setSkinURL(url);
                }
            }
            if (compoundTag.contains(DATA_SKIN_UUID_TAG)) {
                UUID skinUUID = compoundTag.getUUID(DATA_SKIN_UUID_TAG);
                if (skinUUID != null) {
                    this.setSkinUUID(skinUUID);
                }
            }
        }
    }

    String getSkinName() {
        return entityData.get(DATA_SKIN_NAME);
    }

    void setSkinName(String skin) {
        entityData.set(DATA_SKIN_NAME, skin != null ? skin : "");
    }

    public String getSkinURL() {
        return entityData.get(DATA_SKIN_URL);
    }

    void setSkinURL(String skinURL) {
        entityData.set(DATA_SKIN_URL, skinURL != null ? skinURL : "");
    }

    public Optional<UUID> getSkinUUID() {
        return entityData.get(DATA_SKIN_UUID);
    }

    void setSkinUUID(UUID uuid) {
        entityData.set(DATA_SKIN_UUID, Optional.of(uuid));
    }

    void setSkinUUID(Optional<UUID> uuid) {
        entityData.set(DATA_SKIN_UUID, uuid);
    }

    public SkinType getSkinType() {
        return entityData.get(DATA_SKIN_TYPE);
    }

    SkinType getSkinType(String name) {
        return SkinType.get(name);
    }

    void setSkinType(SkinType skinType) {
        entityData.set(DATA_SKIN_TYPE, skinType);
    }

    public SkinModel getSkinModel() {
        return skinModel;
    }
}
