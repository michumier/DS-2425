package platforms;

import java.awt.Point;

import graphics.Image2D;

public interface Platform {

    Image2D loadFile(String name);

    void paint(int x, int y, Image2D image);

    Point getMouseClick();

}