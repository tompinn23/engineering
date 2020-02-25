package tjp.machinist.blocks.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tjp.machinist.Machinist;
import tjp.machinist.items.ModItems;

import javax.annotation.Nullable;

public class BlastFurnaceController extends Block implements ITileEntityProvider {
    public BlastFurnaceController() {
        super(Material.ROCK);
        setUnlocalizedName(Machinist.MODID + ".blastfurnacecontroller");
        setRegistryName("machineframe");
        setCreativeTab(ModItems.tabMachinistMod);
        //setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false));

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new BlastFurnaceControllerTE();
    }
}
