package editor.core;

/*
   Represents a rectangular area in the screen, usually as a result of the user
   interaction with the mouse in the drawing. When the mouse button is pressed
   an empty area is created at that point (its dimensions are 0x0). Then, every
   time the mouse is dragged, the area is resized to include the new point.
   Note that it allows to move the mouse in any direction: up and right, up and
   left, down and left, and down and right.
 */
public class Area {

    private Point start;
    private Point end;

    public Area(int x, int y) {
        start = new Point(x, y);
        end = new Point(start);
    }

    public void resizeTo(int x, int y) {
        end = new Point(x, y);
    }

    // Always returns the top-left corner of the area, regardless of the start
    // and end points. That is, it is independent of the direction in which the
    // user has dragged the mouse.
    //
    public Point topLeft() {
        int x = Math.min(start.x(), end.x());
        int y = Math.min(start.y(), end.y());
        return new Point(x, y);
    }

    // Always returns the bottom-right corner of the area, regardless of the start
    // and end points. That is, it is independent of the direction in which the
    // user has dragged the mouse.
    //
    public Point bottomRight() {
        int x = Math.max(start.x(), end.x());
        int y = Math.max(start.y(), end.y());
        return new Point(x, y);
    }

    public int width() {
        return Math.abs(start.x() - end.x());
    }

    public int height() {
        return Math.abs(start.y() - end.y());
    }
}
