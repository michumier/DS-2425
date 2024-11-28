package platforms.playstation;

import java.awt.Point;

import game.BallGame;
import graphics.Image2D;

public class PlayStationGame extends BallGame {

    private Playstation5API api = new Playstation5API();

	
	public Point getMouseClick() {
		return api.getJoystick();

	}

	public Image2D loadFile(String file) {
		return api.loadGraphics(file);
	}

	public void paint(int x, int y, Image2D image) {
		api.render(x, y, image);
	}

}