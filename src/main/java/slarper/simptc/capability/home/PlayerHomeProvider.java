package slarper.simptc.capability.home;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerHomeProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IPlayerHome.class)
    public static final Capability<IPlayerHome> PLAYER_HOME_CAPABILITY = null;

    private final IPlayerHome instance = PLAYER_HOME_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == PLAYER_HOME_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == PLAYER_HOME_CAPABILITY ? PLAYER_HOME_CAPABILITY.cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return PLAYER_HOME_CAPABILITY.getStorage().writeNBT(PLAYER_HOME_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        PLAYER_HOME_CAPABILITY.getStorage().readNBT(PLAYER_HOME_CAPABILITY, this.instance, null, nbt);
    }

}
