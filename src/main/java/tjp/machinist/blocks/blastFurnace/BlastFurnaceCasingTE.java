package tjp.machinist.blocks.blastFurnace;


import jdk.nashorn.internal.ir.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import tjp.machinist.ModBlocks;
import tjp.machinist.multiblock.MultiblockControllerBase;
import tjp.machinist.multiblock.MultiblockTileEntityBase;
import tjp.machinist.multiblock.MultiblockValidationException;
import tjp.machinist.multiblock.rectangular.RectangularMultiblockTileEntityBase;

import java.util.HashSet;
import java.util.Set;

public class BlastFurnaceCasingTE extends RectangularMultiblockTileEntityBase {
    public BlastFurnaceCasingTE() {
        super();
    }

    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {
        super.onMachineAssembled(multiblockControllerBase);
    }


    @Override
    public void isGoodForFrame() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException {
        throw new MultiblockValidationException(String.format("%d %d %d - Interior should be air.", pos.getX(), pos.getY(),pos.getZ()));
    }

    @Override
    public void onMachineBroken() {
        super.onMachineBroken();
    }

    @Override
    public void onMachineActivated() {
    //Re render.
    }

    @Override
    public void onMachineDeactivated() {
        //re render
    }

    @Override
    public MultiblockControllerBase createNewMultiblock() {
        return new BlastFurnaceTE(this.world);
    }

    @Override
    public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
        return BlastFurnaceTE.class;
    }


}
