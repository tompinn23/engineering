package tjp.machinist.blocks.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tjp.machinist.Machinist;
import tjp.machinist.items.ModItems;

public class BlastFurnaceCasing extends Block {
    public BlastFurnaceCasing() {
        super(Material.ROCK);
        setUnlocalizedName(Machinist.MODID + ".blastfurnacecasing");
        setRegistryName("blastfurnacecasing");
        setCreativeTab(ModItems.tabMachinistMod);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
