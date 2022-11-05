package slarper.simptc.capability.back;

import net.minecraft.util.math.BlockPos;

public class PlayerBack implements IPlayerBack {
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
