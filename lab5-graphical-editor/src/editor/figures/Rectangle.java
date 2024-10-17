package editor.figures;

import java.io.PrintWriter;

import editor.core.*;

public class Rectangle implements Figure {

    private Point topLeft;
    private int width;
    private int height;

    public Rectangle(Area area) {
        this(area.topLeft(), area.width(), area.height());
    }

    public Rectangle(Point topLeft, int width, int height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException("Width and height can be zero, but cannot be negative");
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(PrintWriter output) {
        output.printf("Rectángulo en %s con ancho %d y alto %d\n", topLeft, width, height);
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= topLeft.x() && x <= topLeft.x() + width
                && y >= topLeft.y() && y <= topLeft.y() + height;
    }

    @Override
    public void moveBy(int dx, int dy) {
        topLeft.translate(dx, dy);
    }

    public Point topLeft() {
        return topLeft;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
