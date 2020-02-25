package tjp.machinist.blocks.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.tools.nsc.settings.Final;
import tjp.machinist.Machinist;
import tjp.machinist.items.ModItems;

public class BlastFurnaceCasing extends Block {

    public enum CasingBorder implements IStringSerializable {
        BL,
        ML,
        TL,
        BR,
        MR,
        MT,
        M,
        MB,
        ;

        @Override
        public String getName() {
            switch(this) {
                case BL:
                    return "bl";
                case ML:
                    return "ml";
                case TL:
                    return "tl";
                case BR:
                    return "br";
                case MR:
                    return "mr";
                case MT:
                    return "mt";
                case MB:
                    return "mb";
                default:
                case M:
                    return "m";
            }
        }
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyEnum<CasingBorder> BORDER = PropertyEnum.create("border", CasingBorder.class);

    public BlastFurnaceCasing() {
        super(Material.ROCK);
        setUnlocalizedName(Machinist.MODID + ".blastfurnacecasing");
        setRegistryName("blastfurnacecasing");
        setCreativeTab(ModItems.tabMachinistMod);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }


    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, BORDER);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
