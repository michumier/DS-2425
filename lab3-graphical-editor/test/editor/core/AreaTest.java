package editor.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class AreaTest {

    private Area area;
    private Point start; // (8, 6)

    @BeforeEach
    void setUp() {
        start = new Point(8, 6);
        area = new Area(8, 6);
    }

    @Test
    void testInitialDimensions() {
        assertEquals(start, area.topLeft());
        assertEquals(0, area.width());
        assertEquals(0, area.height());
    }

    @Test
    void testResizeRightUpwards() {
        area.resizeTo(12, 3);
        assertEquals(new Point(8, 3), area.topLeft());
        testDimensions(4, 3);
    }


    @Test
    void testResizeLeftUpwards() {
        area.resizeTo(4, 3);
        assertEquals(new Point(4, 3), area.topLeft());
        testDimensions(4, 3);
    }

    @Test
    void testResizeLeftDownwards() {
        area.resizeTo(4, 9);
        assertEquals(new Point(4, 6), area.topLeft());
        testDimensions(4, 3);
    }

    @Test
    void testResizeRightDownwards() {
        area.resizeTo(12, 9);
        assertEquals(start, area.topLeft());
        testDimensions(4, 3);
    }

    private void testDimensions(int width, int height) {
        assertEquals(width, area.width());
        assertEquals(height, area.height());
    }
}
