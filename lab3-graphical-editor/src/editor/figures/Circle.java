package editor.figures;

import java.io.PrintWriter;

import editor.core.*;

public class Circle implements Figure {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be greater than zero");
        this.center = center;
        this.radius = radius;
    }

    public Circle(Area area) {
        if (area.width() == 0 || area.height() == 0)
            throw new IllegalArgumentException("Width and height must be greater than zero");
        int x = area.topLeft().x() + area.width() / 2;
        int y = area.topLeft().y() + area.height() / 2;
        center = new Point(x, y);
        radius = Math.min(area.width(), area.height()) / 2;
    }

    @Override
    public void draw(PrintWriter output) {
        output.printf("Circle at %s with radius %d\n", center, radius);
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
