package slarper.simptc.capability;

import net.minecraft.util.math.BlockPos;

public interface IPlayerBlockPos {
    BlockPos get();
    void set(BlockPos pos);
}
