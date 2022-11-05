package slarper.simptc.capability.back;

import net.minecraft.util.math.BlockPos;
import slarper.simptc.capability.IPlayerBlockPos;

public class PlayerBack implements IPlayerBlockPos {
    private BlockPos back = new BlockPos(0, 60, 0);

    @Override
    public BlockPos get() {
        return this.back;
    }

    @Override
    public void set(BlockPos pos) {
        this.back = pos;
    }
}
