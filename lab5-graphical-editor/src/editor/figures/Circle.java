package editor.figures;

import java.io.PrintWriter;

import editor.core.*;

public class Circle implements Figure {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        checkRadius(radius);
    }

    // Creates a circle that fits inside the given area. If the area is not a
    // square, the circle is centered in the area and its radius is half the
    // minimum of the width and height of the rectangle.
    //
    public Circle(Area area) {
        int x = area.topLeft().x() + area.width() / 2;
        int y = area.topLeft().y() + area.height() / 2;
        center = new Point(x, y);
        radius = Math.min(area.width(), area.height()) / 2;
        checkRadius(radius);
    }

    // Radius can be zero (an empty circle), but cannot be negative.
    private void checkRadius(int radius) {
        if (radius < 0)
            throw new IllegalArgumentException("Radius cannot be negative");
    }

    @Override
    public void draw(PrintWriter output) {
        output.printf("Círculo con centro en %s y de radio %d\n", center, radius);
    }

    @Override
    public boolean contains(int x, int y) {
        return Math.pow((double) x - center.x(), 2) + Math.pow((double) y - center.y(), 2) <= Math.pow(radius, 2);
    }

    @Override
    public void moveBy(int dx, int dy) {
        center.translate(dx, dy);
    }

    public Point center() {
        return center;
    }

    public int radius() {
        return radius;
    }
}
