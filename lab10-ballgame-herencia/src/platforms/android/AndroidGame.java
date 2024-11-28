package platforms.android;

import java.awt.Point;

import game.BallGame;
import graphics.Image2D;

public class AndroidGame extends BallGame {

    private AndroidAPI api = new AndroidAPI();

	
	public Point getMouseClick() {
		return api.getTouch();

	}

	public Image2D loadFile(String file) {
		return api.loadResource(file);
	}

	public void paint(int x, int y, Image2D image) {
		api.draw(x, y, image);
	}

}
