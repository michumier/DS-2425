package editor.figures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.core.Area;
import editor.core.Point;

class CircleTest {

    private Circle circle;
    private Point center;

    @BeforeEach
    void setUp() {
        center = new Point(60, 80);
    }

    @Test
    void testSimpleConstructor() {
        int radius = 20;
        circle = new Circle(center, radius);
        testCircle(radius);
    }

    @Test
    void testConstructorWithNegativeRadius() {
        try {
            circle = new Circle(center, -20);
            fail("Negative radius should throw an exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void testConstructorWithRadiusZero() {
        circle = new Circle(center, 0);
        testEmptyCircle();
    }

    @Test
    void testConstructorWithArea() {
        Area area = new Area(40, 60);
        area.resizeTo(80, 100);
        circle = new Circle(area);
        testCircle(20);
    }

    @Test
    void testConstructorWithEmptyArea() {
        Area area = new Area(60, 80);
        circle = new Circle(area);
        testEmptyCircle();
    }

    //$ Helper methods to test the circle.

    private void testCircle(int radius) {
        assertEquals(center, circle.center());
        assertEquals(radius, circle.radius());
    }

    private void testEmptyCircle() {
        testCircle(0);
    }
}
