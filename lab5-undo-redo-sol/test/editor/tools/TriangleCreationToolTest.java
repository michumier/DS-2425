package editor.tools;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.core.*;
import editor.figures.*;
import editor.tools.figures.TriangleCreationTool;

public class TriangleCreationToolTest {

    private Editor editor;
    private Drawing drawing;
    private TriangleCreationTool tool;

    @BeforeEach
    void setUp() {
        editor = new Editor();
        drawing = editor.drawing();
        tool = new TriangleCreationTool(editor);
    }

    @Test
    void testCreation() {
        assertEquals(0, editor.drawing().figures().size());
        tool.clickedOn(1, 2);
        tool.clickedOn(3, 4);
        // No rectangle has been created yet
        assertNull(drawing.findFigureAt(3, 4));
        tool.clickedOn(5, 6); // Third click
        // A triangle must have been created
        assertNotNull(drawing.findFigureAt(3, 4));
        Triangle triangle = (Triangle) drawing.findFigureAt(3, 4);
        assertEquals(new Point(1, 2), triangle.vertices()[0]);
        assertEquals(new Point(3, 4), triangle.vertices()[1]);
        assertEquals(new Point(5, 6), triangle.vertices()[2]);
        assertEquals(1, editor.drawing().figures().size());
    }

    @Test
    void testReset() {
        tool.clickedOn(1, 2);
        tool.clickedOn(3, 4);
        tool.reset();
        tool.clickedOn(5, 6); // Now it starts again
        tool.clickedOn(1, 2);
        tool.clickedOn(3, 4);
        Triangle triangle = (Triangle) drawing.findFigureAt(3, 4);
        assertEquals(new Point(5, 6), triangle.vertices()[0]);
        assertEquals(new Point(1, 2), triangle.vertices()[1]);
        assertEquals(new Point(3, 4), triangle.vertices()[2]);
        assertEquals(1, editor.drawing().figures().size());
    }
}
