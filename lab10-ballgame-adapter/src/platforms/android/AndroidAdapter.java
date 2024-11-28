package platforms.android;

import java.awt.Point;

import graphics.Image2D;
import platforms.Platform;

public class AndroidAdapter implements Platform {

    private AndroidAPI androidAPI = new AndroidAPI();

    @Override
    public Image2D loadFile(String name) {
        return androidAPI.loadResource(name);
    }

    @Override
    public void paint(int x, int y, Image2D image) {
        androidAPI.draw(x, y, image);
    }

    @Override
    public Point getMouseClick() {
        return androidAPI.getTouch();
    }

}
