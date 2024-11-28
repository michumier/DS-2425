package game;

import java.awt.Point;

import graphics.Image2D;
import platforms.Platform;


// This class, and all the code inside this package, is supposed to be the
// complete game code, and it is what we want to reuse in the different
// platforms.


public class BallGame {
	
	// This variable decides the platform being targeted
	private Platform platform;

	public BallGame(Platform platform){
		this.platform = platform;
	}

	public void play() {
		

		Image2D image = platform.loadFile("ball.png");

		// This simulates the game loop
		for (int i = 0; i < 10; i++) {
			Point point = platform.getMouseClick();
			// Check collision with walls
			// Update score
			// Other game logic
			// ...
			platform.paint(((int)point.getX()),((int)point.getY()), image);
		}
	}

}
