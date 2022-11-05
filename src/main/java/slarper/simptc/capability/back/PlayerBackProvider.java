package slarper.simptc.capability.back;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import slarper.simptc.capability.IPlayerBlockPos;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerBackProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IPlayerBlockPos.class)
    public static final Capability<IPlayerBlockPos> PLAYER_BACK_CAPABILITY = null;

    private final IPlayerBlockPos instance = PLAYER_BACK_CAPABILITY.getDefaultInstance();

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
