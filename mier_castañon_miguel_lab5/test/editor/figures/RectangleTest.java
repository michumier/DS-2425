package editor.figures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.core.Point;

class RectangleTest {

    private Point topLeft;
    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        topLeft = new Point(60, 80);
        rectangle = null;
    }

    @Test
    void testSimpleConstructor() {
        rectangle = new Rectangle(topLeft, 40, 30);
        testRectangle(40, 30);
    }

    @Test
    void testConstructorWithNegativeWidth() {
        try {
            rectangle = new Rectangle(topLeft, -40, 30);
            fail("Negative width should throw an exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void testConstructorWithNegativeHeight() {
        try {
            rectangle = new Rectangle(topLeft, 40, -30);
            fail("Negative height should throw an exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void testConstructorWithZeroHeight() {
        rectangle = new Rectangle(topLeft, 40, 0);
        testRectangle(40, 0);
    }

    @Test
    void testConstructorWithZeroWidth() {
        rectangle = new Rectangle(topLeft, 0, 30);
        testRectangle(0, 30);
    }

    // Helper methods to test the rectangle.

    private void testRectangle(int width, int height) {
        assertEquals(topLeft, rectangle.topLeft());
        assertEquals(width, rectangle.width());
        assertEquals(height, rectangle.height());
    }
}
