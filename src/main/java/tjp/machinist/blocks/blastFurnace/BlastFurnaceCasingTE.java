package tjp.machinist.blocks.blastFurnace;



import tjp.machinist.multiblock.MultiblockControllerBase;

import tjp.machinist.multiblock.rectangular.RectangularMultiblockTileEntityBase;
import tjp.machinist.multiblock.validation.IMultiblockValidator;
import tjp.machinist.multiblock2.MultiblockBaseController;
import tjp.machinist.multiblock2.MultiblockBaseTileEntity;


public class BlastFurnaceCasingTE extends MultiblockBaseTileEntity {
    public BlastFurnaceCasingTE() {
        super();
    }








    @Override
    public Class<? extends MultiblockBaseController> getMultiblockControllerType() {
        return BlastFurnaceControllerTE.class;
    }


}
