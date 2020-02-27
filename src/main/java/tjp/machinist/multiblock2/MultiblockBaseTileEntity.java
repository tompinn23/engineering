package tjp.machinist.multiblock2;

import net.minecraft.tileentity.TileEntity;
import tjp.machinist.blocks.blastFurnace.BlastFurnaceControllerTE;

public abstract class MultiblockBaseTileEntity extends TileEntity {
    public abstract Class<? extends MultiblockBaseController> getMultiblockControllerType();

}
