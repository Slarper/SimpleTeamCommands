package slarper.simptc.capability.home;

import net.minecraft.util.math.BlockPos;
import slarper.simptc.capability.IPlayerBlockPos;

public class PlayerHome implements IPlayerBlockPos {
    private BlockPos home = new BlockPos(0, 60, 0);

    @Override
    public BlockPos get() {
        return this.home;
    }

    @Override
    public void set(BlockPos pos) {
        this.home = pos;
    }
}
