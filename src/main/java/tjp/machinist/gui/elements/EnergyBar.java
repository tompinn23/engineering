package tjp.machinist.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.energy.IEnergyStorage;
import tjp.machinist.Machinist;
import tjp.machinist.gui.GuiBase;

import java.util.ArrayList;
import java.util.List;

public class EnergyBar {

    private static final ResourceLocation energyBar = new ResourceLocation(Machinist.MODID, "textures/gui/energy.png");

    private int xPos;
    private int yPos;


    private GuiBase gc;
    private IEnergyStorage energyStorage;

    public EnergyBar(GuiBase gc, IEnergyStorage energyStorage, int xPos, int yPos) {
        this.gc = gc;
        this.energyStorage = energyStorage;
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public void drawBackground() {
        gc.bindTexture(energyBar);

        gc.drawSizedTexturedModalRect(xPos, yPos, 0, 0, 6, 58, 12, 58);

        double fraction = energyStorage.getEnergyStored() / (double)energyStorage.getMaxEnergyStored();
        fraction = MathHelper.clamp(fraction, 0.0, 1.0);
        gc.bindTexture(energyBar);
        gc.drawSizedTexturedModalRect(xPos, yPos + (int)((1.0 - fraction) * 58), 6, (int)((1.0 - fraction) * 58), 6,58 - ((int)((1.0 - fraction) * 58)), 12, 58);

    }


    public void drawForeground(int mouseX, int mouseY) {
        List<String> hoveringText = new ArrayList<String>();


        // If the mouse is over one of the burn time indicator add the burn time indicator hovering text
        if (isInRect(xPos , yPos, 6, 58, mouseX, mouseY)) {
            hoveringText.add("Energy:");
            hoveringText.add(energyStorage.getEnergyStored() + "/" + energyStorage.getMaxEnergyStored() + "RF");
        }
        // If hoveringText is not empty draw the hovering text
        if (!hoveringText.isEmpty()){
            gc.drawHoveringText(hoveringText, mouseX - xPos, mouseY - yPos);
        }
    }

    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY){
        return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
    }

}
