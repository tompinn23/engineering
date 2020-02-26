package tjp.machinist.blocks.blastFurnace;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.Constants;
import tjp.machinist.multiblock.MultiblockControllerBase;
import tjp.machinist.multiblock.MultiblockValidationException;
import tjp.machinist.multiblock.rectangular.RectangularMultiblockTileEntityBase;
import tjp.machinist.recipes.BlastFurnaceRecipes;

public class BlastFurnaceControllerTE extends RectangularMultiblockTileEntityBase {
    private BlastFurnaceRecipes recipeHandler;



    private EnumFacing facing;

    public BlastFurnaceControllerTE(EnumFacing facing) {
        super();
        this.facing = facing;
    }


    public void setFacing(EnumFacing facing) {
        this.facing = facing;
    }

    public EnumFacing getFacing(EnumFacing facing) {
        return facing;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("facing", facing.getIndex());
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        facing = EnumFacing.values()[nbt.getInteger("facing")];
    }


    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {
        super.onMachineAssembled(multiblockControllerBase);
    }

    @Override
    public void onMachineBroken() {

    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException {
        throw new MultiblockValidationException(String.format("%d %d %d - Controller not valid for frame.", pos.getX(), pos.getY(), pos.getZ()));
    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException {

    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException {
        throw new MultiblockValidationException(String.format("%d %d %d - Controller not valid for top.", pos.getX(), pos.getY(), pos.getZ()));

    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException {
        throw new MultiblockValidationException(String.format("%d %d %d - Controller not valid for bottom.", pos.getX(), pos.getY(), pos.getZ()));

    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException {
        throw new MultiblockValidationException(String.format("%d %d %d - Controller not valid for interior.", pos.getX(), pos.getY(), pos.getZ()));

    }

    @Override
    public void onMachineActivated() {
        //Re render?
    }

    @Override
    public void onMachineDeactivated() {
        // Re render.
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
