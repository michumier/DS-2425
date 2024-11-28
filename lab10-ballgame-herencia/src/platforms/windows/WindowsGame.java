package platforms.windows;

import java.awt.Point;

import game.BallGame;
import graphics.Image2D;

public class WindowsGame extends BallGame {

    private WindowsAPI api = new WindowsAPI();

	
	public Point getMouseClick() {
		return api.getMouseClick();

	}

	public Image2D loadFile(String file) {
		return api.loadFile(file);
	}

	public void paint(int x, int y, Image2D image) {
		api.paint(x, y, image);
	}

}
