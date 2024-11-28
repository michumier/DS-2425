package game;

import java.awt.Point;

import graphics.Image2D;


// This class, and all the code inside this package, is supposed to be the
// complete game code, and it is what we want to reuse in the different
// platforms.


public abstract class BallGame {
	


	public void play() {
		

		//Image2D image = platform.loadFile("ball.png");
		Image2D image = loadFile("ball.png");


		// This simulates the game loop
		for (int i = 0; i < 10; i++) {
			Point point = getMouseClick();
			// Check collision with walls
			// Update score
			// Other game logic
			// ...
			paint(((int)point.getX()),((int)point.getY()), image);
		}
	}

	public abstract Image2D loadFile(String file);
	public abstract void paint(int x, int y, Image2D image);
	public abstract Point getMouseClick();

}
