package platforms.android;

import java.awt.Point;

import graphics.Image2D;

public class AndroidAPI {
	
	private Point point = new Point(0, 0);

	public Image2D loadResource(String name) {
		System.out.println("(Android) Image '" + name + "' loaded from flash memory.");
		return new Image2D(name, 10, 10);
	}

	public void draw(int x, int y, Image2D image) {
		System.out.println("(Android) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user touches the screen
	public Point getTouch() {
		point.translate(10, 10);
		return new Point(point);
	}
}
