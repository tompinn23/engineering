package tjp.machinist.blocks.blastFurnace;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import tjp.machinist.multiblock.IMultiblockPart;
import tjp.machinist.multiblock.MultiblockControllerBase;
import tjp.machinist.multiblock.MultiblockValidationException;
import tjp.machinist.multiblock.rectangular.RectangularMultiblockControllerBase;

import java.util.HashSet;
import java.util.Set;

public class BlastFurnaceTE extends RectangularMultiblockControllerBase {

    private Set<BlastFurnaceControllerTE> attachedControllers;

    protected BlastFurnaceTE(World world) {
        super(world);
        attachedControllers = new HashSet<>();
    }

    @Override
    public void onAttachedPartWithMultiblockData(IMultiblockPart part, NBTTagCompound data) {

    }

    @Override
    protected void onBlockAdded(IMultiblockPart newPart) {
        connectedParts.add(newPart);
        if(newPart instanceof BlastFurnaceControllerTE)
            attachedControllers.add((BlastFurnaceControllerTE)newPart);

    }

    @Override
    protected void onBlockRemoved(IMultiblockPart oldPart) {
        connectedParts.remove(oldPart);
        if(oldPart instanceof BlastFurnaceControllerTE)
            attachedControllers.remove((BlastFurnaceControllerTE)oldPart);

    }

    @Override
    protected void onMachineAssembled() {

    }

    @Override
    protected void onMachineRestored() {

    }

    @Override
    protected void onMachinePaused() {

    }

    @Override
    protected void onMachineDisassembled() {

    }

    @Override
    protected int getMinimumNumberOfBlocksForAssembledMachine() {
        return 26;
    }

    @Override
    protected int getMaximumXSize() {
        return 3;
    }

    @Override
    protected int getMaximumZSize() {
        return 3;
    }

    @Override
    protected int getMaximumYSize() {
        return 3;
    }

    @Override
    protected int getMinimumXSize() {
        return 3;
    }

    @Override
    protected int getMinimumZSize() {
        return 3;
    }

    @Override
    protected int getMinimumYSize() {
        return 3;
    }

    @Override
    protected void isMachineWhole() throws MultiblockValidationException {
        if(connectedParts.size() < getMinimumNumberOfBlocksForAssembledMachine()) {
            throw new MultiblockValidationException("Machine not complete.");
        }
        if(attachedControllers.size() < 1) {
            throw new MultiblockValidationException("Need 1 controller");
        }
        super.isMachineWhole();
    }

    @Override
    protected void onAssimilate(MultiblockControllerBase assimilated) {

    }

    @Override
    protected void onAssimilated(MultiblockControllerBase assimilator) {

    }

    @Override
    protected boolean updateServer() {
        return false;
    }

    @Override
    protected void updateClient() {

    }

    @Override
    public void writeToNBT(NBTTagCompound data) {

    }

    @Override
    public void readFromNBT(NBTTagCompound data) {

    }

    @Override
    public void formatDescriptionPacket(NBTTagCompound data) {

    }

    @Override
    public void decodeDescriptionPacket(NBTTagCompound data) {

    }
}
