package tjp.machinist.multiblock.rectangular;


import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import tjp.machinist.multiblock.MultiblockControllerBase;
import tjp.machinist.multiblock.MultiblockTileEntityBase;
import tjp.machinist.multiblock.MultiblockValidationException;

public abstract class RectangularMultiblockTileEntityBase extends
		MultiblockTileEntityBase {

	PartPosition position;
	EnumFacing outwards;
	
	public RectangularMultiblockTileEntityBase() {
		super();
		
		position = PartPosition.Unknown;
		outwards = null;
	}

	// Positional Data
	public EnumFacing getOutwardsDir() {
		return outwards;
	}
	
	public PartPosition getPartPosition() {
		return position;
	}

	// Handlers from MultiblockTileEntityBase 
	@Override
	public void onAttached(MultiblockControllerBase newController) {
		super.onAttached(newController);
		recalculateOutwardsDirection(newController.getMinimumCoord(), newController.getMaximumCoord());
	}
	
	
	@Override
	public void onMachineAssembled(MultiblockControllerBase controller) {
		BlockPos maxCoord = controller.getMaximumCoord();
		BlockPos minCoord = controller.getMinimumCoord();
		
		// Discover where I am on the reactor
		recalculateOutwardsDirection(minCoord, maxCoord);
	}

	@Override
	public void onMachineBroken() {
		position = PartPosition.Unknown;
		outwards = null;
	}
	
	// Positional helpers
	public void recalculateOutwardsDirection(BlockPos minCoord, BlockPos maxCoord) {
		outwards = null;
		position = PartPosition.Unknown;

		int facesMatching = 0;
		if(maxCoord.getX() == this.pos.getX() || minCoord.getX() == this.pos.getX()) { facesMatching++; }
		if(maxCoord.getY() == this.pos.getY() || minCoord.getY() == this.pos.getY()) { facesMatching++; }
		if(maxCoord.getZ() == this.pos.getZ() || minCoord.getZ() == this.pos.getZ()) { facesMatching++; }
		
		if(facesMatching <= 0) { position = PartPosition.Interior; }
		else if(facesMatching >= 3) { position = PartPosition.FrameCorner; }
		else if(facesMatching == 2) { position = PartPosition.Frame; }
		else {
			// 1 face matches
			if(maxCoord.getX() == this.pos.getX()) {
				position = PartPosition.EastFace;
				outwards = EnumFacing.EAST;
			}
			else if(minCoord.getX() == this.pos.getX()) {
				position = PartPosition.WestFace;
				outwards = EnumFacing.WEST;
			}
			else if(maxCoord.getZ() == this.pos.getZ()) {
				position = PartPosition.SouthFace;
				outwards = EnumFacing.SOUTH;
			}
			else if(minCoord.getZ() == this.pos.getZ()) {
				position = PartPosition.NorthFace;
				outwards = EnumFacing.NORTH;
			}
			else if(maxCoord.getY() == this.pos.getY()) {
				position = PartPosition.TopFace;
				outwards = EnumFacing.UP;
			}
			else {
				position = PartPosition.BottomFace;
				outwards = EnumFacing.DOWN;
			}
		}
	}
	
	///// Validation Helpers (IMultiblockPart)
	public abstract void isGoodForFrame() throws MultiblockValidationException;

	public abstract void isGoodForSides() throws MultiblockValidationException;

	public abstract void isGoodForTop() throws MultiblockValidationException;

	public abstract void isGoodForBottom() throws MultiblockValidationException;

	public abstract void isGoodForInterior() throws MultiblockValidationException;
}
