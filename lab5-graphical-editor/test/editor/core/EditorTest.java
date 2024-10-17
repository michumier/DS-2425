package editor.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.figures.*;
import editor.tools.SelectionTool;

import static editor.core.TestEditor.*;

class EditorTest {

    private Editor editor;
    private Drawing drawing;

    @BeforeEach
    void setUp() {
        editor = new TestEditor();
        drawing = editor.drawing();
    }

    @Test
    void testDrawing() {
        assertNotNull(editor.drawing());
    }

    @Test
    void testDefaultTool() {
        assertNotNull(editor.defaultTool());
        assertTrue(editor.defaultTool() instanceof SelectionTool);
    }

    @Test
    void testCreateRectangle() {
        editor.toolButtonPressed(RECTANGLE);
        editor.mousePressed(100, 100);
        editor.mouseReleased(300, 200);
        assertEquals(1, drawing.figures().size());
        Rectangle rectangle = (Rectangle) drawing.figures().getFirst();
        assertEquals(new Point(100, 100), rectangle.topLeft());
        assertEquals(200, rectangle.width());
        assertEquals(100, rectangle.height());
        // Now the default tool is active
        assertTrue(editor.currentTool() == editor.defaultTool());
    }

    @Test
    void testCreateCircle() {
        editor.toolButtonPressed(CIRCLE);
        editor.mousePressed(400, 400);
        editor.mouseReleased(600, 600);
        assertEquals(1, drawing.figures().size());
        Circle circle = (Circle) drawing.figures().getFirst();
        assertEquals(new Point(500, 500), circle.center());
        assertEquals(100, circle.radius());
        // Now the default tool is active
        assertTrue(editor.currentTool() == editor.defaultTool());
    }

    @Test
    void testCreateTriangle() {
        editor.toolButtonPressed(TRIANGLE);
        editor.mousePressed(2, 1);
        editor.mousePressed(1, 2);
        editor.mousePressed(3, 2);
        assertEquals(1, drawing.figures().size());
        Triangle triangle = (Triangle) drawing.figures().getFirst();
        assertEquals(new Point(2, 1), triangle.vertices()[0]);
        assertEquals(new Point(1, 2), triangle.vertices()[1]);
        assertEquals(new Point(3, 2), triangle.vertices()[2]);
        // Now the default tool is active
        assertTrue(editor.currentTool() == editor.defaultTool());
    }

    @Test
    void testCancelTriangleCreation() {
        editor.toolButtonPressed(TRIANGLE);
        editor.mousePressed(2, 1);
        editor.mousePressed(1, 2);
        // Now the user selects another tool
        editor.toolButtonPressed(RECTANGLE);
        // And comes back to the triangle tool
        editor.toolButtonPressed(TRIANGLE);
        editor.mousePressed(3, 2); // Now it is the first click!
        assertTrue(drawing.figures().isEmpty()); // No triangle has been created
        // Other two clicks
        editor.mousePressed(1, 2);
        editor.mousePressed(3, 2);
        // Now a triangle must have been created
        assertEquals(1, drawing.figures().size());
        Triangle triangle = (Triangle) drawing.figures().getFirst();
        assertEquals(new Point(3, 2), triangle.vertices()[0]);
        assertEquals(new Point(1, 2), triangle.vertices()[1]);
        assertEquals(new Point(3, 2), triangle.vertices()[2]);
    }
}
