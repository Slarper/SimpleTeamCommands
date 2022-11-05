package slarper.simptc.capability.back;

import net.minecraft.util.math.BlockPos;

public interface IPlayerBack {
    BlockPos get();
    void set(BlockPos pos);
}
