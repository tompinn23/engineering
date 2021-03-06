package tjp.machinist;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tjp.machinist.blocks.MachineFrame;
import tjp.machinist.blocks.crusher.Crusher;
import tjp.machinist.blocks.smelter.Smelter;

public class ModBlocks {

    @GameRegistry.ObjectHolder("machinist:machineframe")
    public static MachineFrame machineFrame;

    @GameRegistry.ObjectHolder("machinist:smelter")
    public static Smelter smelter;

    @GameRegistry.ObjectHolder("machinist:crusher")
    public static Crusher crusher;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        machineFrame.initModel();
        smelter.initModel();
        crusher.initModel();
    }
}
