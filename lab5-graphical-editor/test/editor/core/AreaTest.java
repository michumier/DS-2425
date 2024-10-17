package editor.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class AreaTest {

    private Area area;

    private void testDimensions(int width, int height) {
        assertEquals(width, area.width());
        assertEquals(height, area.height());
    }

    @Test
    void testInitialDimensions() {
        Point start = new Point(10, 20);
        area = new Area(10, 20);
        assertEquals(start, area.topLeft());
        assertEquals(start, area.bottomRight());
        assertEquals(0, area.width());
        assertEquals(0, area.height());
    }

    // Tests to assert that the area is resized correctly in each of the four
    // cuadrants (to the top right, top left, bottom left, and bottom right).
    // In each case, the resultant area must be a rectangle of 40 x 30, with the
    // top left corner at (80, 60) and the bottom right corner at (120, 90).

    /*
     
         (80, 60)           (120, 60)
            +-------------------+           \
            |                   |           |
            |                   |           | 30
            |                   |           |
            +-------------------+           \
         (80, 90)           (120, 90)

            /-------- 40 -------/

     */

    private void testArea() {
        Point topLeft = new Point(80, 60);
        Point bottomRight = new Point(120, 90);
        assertEquals(topLeft, area.topLeft());
        assertEquals(bottomRight, area.bottomRight());
        testDimensions(40, 30);
    }

    @Test
    void testResizeTopRight() {
        area = new Area(80, 90);
        area.resizeTo(120, 60);
        testArea();
    }

    @Test
    void testResizeTopLeft() {
        area = new Area(120, 90);
        area.resizeTo(80, 60);
        testArea();
    }

    @Test
    void testResizeBottomLeft() {
        area = new Area(120, 60);
        area.resizeTo(80, 90);
        testArea();
    }

    @Test
    void testResizeBottomRight() {
        area = new Area(80, 60);
        area.resizeTo(120, 90);
        testArea();
    }

    // Tests to assert that the area is resized correctly when only one axis
    // is changed (that is, the area is resized only in the x or y axis, while
    // the other remains the same). Particularly, when this is done right after
    // the creation of the area, they check that the other dimension is 0.

    /*
         (80, 60)           (120, 60)
            +-------------------+       0
                    40
     */

    @Test
    void testResizeRight() {
        area = new Area(80, 60);
        area.resizeTo(120, 60);
        assertEquals(new Point(80, 60), area.topLeft());
        assertEquals(new Point(120, 60), area.bottomRight());
        testDimensions(40, 0);
    }

    @Test
    void testResizeLeft() {
        area = new Area(120, 60);
        area.resizeTo(80, 60);
        assertEquals(new Point(80, 60), area.topLeft());
        assertEquals(new Point(120, 60), area.bottomRight());
        testDimensions(40, 0);
    }

    /*
         (80, 60)
            +
            |
            | 30
            |
            +
         (80, 90)
            
            0
     */

    @Test
    void testResizeBottom() {
        area = new Area(80, 60);
        area.resizeTo(80, 90);
        assertEquals(new Point(80, 60), area.topLeft());
        assertEquals(new Point(80, 90), area.bottomRight());
        testDimensions(0, 30);
    }

    @Test
    void testResizeTop() {
        area = new Area(80, 90);
        area.resizeTo(80, 60);
        assertEquals(new Point(80, 60), area.topLeft());
        assertEquals(new Point(80, 90), area.bottomRight());
        testDimensions(0, 30);
    }
}
