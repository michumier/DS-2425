package editor.figures;

import java.io.PrintWriter;

import editor.core.*;

public class Triangle implements Figure {

    private Point v1;
    private Point v2;
    private Point v3;

    public Triangle(Point a, Point b, Point c) {
        v1 = a;
        v2 = b;
        v3 = c;
    }

    @Override
    public void draw(PrintWriter output) {
        output.printf("Triangle: %s, %s, and %s\n", v1, v2, v3);
    }

    @Override
    public boolean contains(int x, int y) {
        Point point = new Point(x, y);
        return point.equals(v1) || point.equals(v2) || point.equals(v3);
    }

    @Override
    public void moveBy(int dx, int dy) {
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }

    public Point[] vertices() {
        return new Point[] { v1, v2, v3 };
    }
}
