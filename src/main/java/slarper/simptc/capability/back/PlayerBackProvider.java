package slarper.simptc.capability.back;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerBackProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IPlayerBack.class)
    public static final Capability<IPlayerBack> PLAYER_BACK_CAPABILITY = null;

    private final IPlayerBack instance = PLAYER_BACK_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == PLAYER_BACK_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == PLAYER_BACK_CAPABILITY ? PLAYER_BACK_CAPABILITY.cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return PLAYER_BACK_CAPABILITY.getStorage().writeNBT(PLAYER_BACK_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        PLAYER_BACK_CAPABILITY.getStorage().readNBT(PLAYER_BACK_CAPABILITY, this.instance, null, nbt);
    }

}
