package tjp.machinist.multiblock2;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public abstract class MultiblockBaseController extends MultiblockBaseTileEntity implements ITickable {

    private long timer = 0L;
    protected boolean formed;

    @Override
    public void update() {
        timer++;
        if(!world.isRemote) {
            if(timer % 20 == 0) {
                checkPattern();
            }
        }
    }

    public abstract void checkPattern();
}
