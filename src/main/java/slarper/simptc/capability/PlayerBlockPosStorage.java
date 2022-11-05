package slarper.simptc.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class PlayerBlockPosStorage implements Capability.IStorage<IPlayerBlockPos> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IPlayerBlockPos> capability, IPlayerBlockPos instance, EnumFacing side) {
        int[] intArray = new int[]{
                instance.get().getX(),
                instance.get().getY(),
                instance.get().getZ()
        };
        return new NBTTagIntArray(intArray);
    }

    @Override
    public void readNBT(Capability<IPlayerBlockPos> capability, IPlayerBlockPos instance, EnumFacing side, NBTBase nbt) {
        BlockPos pos = new BlockPos(
                ((NBTTagIntArray)nbt).getIntArray()[0],
                ((NBTTagIntArray)nbt).getIntArray()[1],
                ((NBTTagIntArray)nbt).getIntArray()[2]
        );

        instance.set(pos);
    }
}
