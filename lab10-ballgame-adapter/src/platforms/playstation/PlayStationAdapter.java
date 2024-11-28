package platforms.playstation;

import java.awt.Point;

import graphics.Image2D;
import platforms.Platform;

public class PlayStationAdapter implements Platform {

    private Playstation5API playstation5api = new Playstation5API();

    @Override
    public Image2D loadFile(String name) {
        return playstation5api.loadGraphics(name);
    }

    @Override
    public void paint(int x, int y, Image2D image) {
        playstation5api.render(x, y, image);
    }

    @Override
    public Point getMouseClick() {
        return playstation5api.getJoystick();
    }

}
