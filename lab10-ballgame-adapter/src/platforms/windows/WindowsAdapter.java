package platforms.windows;

import java.awt.Point;

import graphics.Image2D;
import platforms.Platform;

public class WindowsAdapter implements Platform{

    private WindowsAPI windowsAPI = new WindowsAPI();



    @Override
    public Image2D loadFile(String name) {
        return windowsAPI.loadFile(name);
    }

    @Override
    public void paint(int x, int y, Image2D image) {
        windowsAPI.paint(x, y, image);
    }

    @Override
    public Point getMouseClick() {
        return windowsAPI.getMouseClick();
    }

}
