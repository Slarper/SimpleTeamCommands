package slarper.simptc.capability.home;

import net.minecraft.util.math.BlockPos;

public interface IPlayerHome {
    BlockPos getPlayerHome();
    void setPlayerHome(BlockPos home);
}
