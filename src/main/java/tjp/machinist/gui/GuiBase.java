package tjp.machinist.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBase extends GuiContainer {

    public GuiBase(Container inventorySlotsIn) {
        super(inventorySlotsIn);
    }

    public void bindTexture(ResourceLocation texture) {
        this.mc.renderEngine.bindTexture(texture);
    }


    public void drawSizedTexturedModalRect(int x, int y, int u, int v, int width, int height, float textureWidth,
                                           float textureHeight) {
        Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, width, height, textureWidth, textureHeight);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
