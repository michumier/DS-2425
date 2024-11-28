package platforms.playstation;

import java.awt.Point;

import graphics.Image2D;

public class Playstation5API {
	
	private Point point = new Point(0, 0);

	public Image2D loadGraphics(String name) {
		System.out.println("(PS5) Image loaded '" + name + "' from DVD.");
		return new Image2D(name, 10, 10);
	}

	public void render(int x, int y, Image2D image) {
		System.out.println("(PS5) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user presses the "X" button of the controller
	public Point getJoystick() {
		point.translate(10, 10);
		return new Point(point);
	}
}
