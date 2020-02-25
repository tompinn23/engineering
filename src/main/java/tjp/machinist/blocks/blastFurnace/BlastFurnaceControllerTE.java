package tjp.machinist.blocks.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import tjp.machinist.ModBlocks;
import tjp.machinist.recipes.BlastFurnaceRecipes;

public class BlastFurnaceControllerTE extends TileEntity implements ITickable {

    private BlastFurnaceRecipes recipeHandler;

    private boolean completed = false;

    public BlastFurnaceControllerTE() {
        recipeHandler = BlastFurnaceRecipes.instance();
    }

    @Override
    public void update() {
        BlockPos current = this.pos.down();
        if(!this.world.isRemote) {
            // Run Checks
            if (!completed) {
                EnumFacing orient = EnumFacing.UP;
                for(EnumFacing facing : EnumFacing.HORIZONTALS) {
                    if (this.world.getBlockState(this.pos.offset(facing, 2)).getBlock() == ModBlocks.blastCasing) {
                        orient = facing;
                        break;
                    }
                }
                if(orient == EnumFacing.UP)
                    return;
                //Bottom Layer
                if(this.world.getBlockState(current).getBlock() == ModBlocks.blastCasing) {
                    for(int i = 0; i < 3; i++) {
                        if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateY())).getBlock() != ModBlocks.blastCasing)
                            return;
                        if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateYCCW())).getBlock() != ModBlocks.blastCasing)
                            return;
                        if(this.world.getBlockState(current.offset(orient, i)).getBlock() != ModBlocks.blastCasing)
                            return;
                    }
                }
                else {
                    return;
                }
                current = this.pos;
                //Middle Layer
                for(int i = 0; i < 3; i++) {
                    if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateY())).getBlock() != ModBlocks.blastCasing)
                        return;
                    if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateYCCW())).getBlock() != ModBlocks.blastCasing)
                        return;
                }
                if(this.world.getBlockState(current.offset(orient)).getBlock() != Blocks.AIR)
                    return;
                current = this.pos.up();
                        for(int i = 0; i < 3; i++) {
                            if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateY())).getBlock() != ModBlocks.blastCasing)
                                return;
                            if(this.world.getBlockState(current.offset(orient, i).offset(orient.rotateYCCW())).getBlock() != ModBlocks.blastCasing)
                                return;
                            if(this.world.getBlockState(current.offset(orient, i)).getBlock() != ModBlocks.blastCasing)
                                return;
                        }
                completed = true;
            }
            else {
                //Do Processing
            }
        }
    }
}