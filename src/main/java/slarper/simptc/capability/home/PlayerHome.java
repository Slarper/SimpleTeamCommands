package slarper.simptc.capability.home;

import net.minecraft.util.math.BlockPos;

public class PlayerHome implements IPlayerHome{
    private BlockPos home = new BlockPos(0, 60, 0);

    @Override
    public BlockPos getPlayerHome() {
        return this.home;
    }

    @Override
    public void setPlayerHome(BlockPos home) {
        this.home = home;
    }
}
