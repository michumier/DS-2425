package editor.tools;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.core.*;

abstract class AbstractCreationToolTest {

    private Editor editor;
    private Drawing drawing;
    private Tool tool;

    private Point topLeft; // (100, 100)
    private Point bottomRight; // (300, 200)

    @BeforeEach
    void setUp() {
        editor = new Editor();
        tool = createTool(editor);
        drawing = editor.drawing();
        topLeft = new Point(100, 100);
        bottomRight = new Point(300, 200);
    }

    protected abstract Tool createTool(Editor editor);

    @Test
    void testSimpleCreation() {
        tool.clickedOn(100, 100);
        // No figure has been created yet
        assertTrue(drawing.figures().isEmpty());
        tool.releasedOn(300, 200);
        // After releasing the mouse, a figure must have been created
        assertEquals(1, editor.drawing().figures().size());
        Figure figure = drawing.figures().getFirst();
        testFigure(figure, topLeft, bottomRight);
    }

    @Test
    void testCreationWithMoves() {
        tool.clickedOn(100, 100);
        tool.movedTo(-999, 18);
        tool.movedTo(46, 280);
        tool.movedTo(690, -188);
        // No figure has been created yet
        assertTrue(drawing.figures().isEmpty());
        tool.releasedOn(300, 200);
        // After releasing the mouse, a figure must have been created
        assertEquals(1, editor.drawing().figures().size());
        Figure figure = drawing.figures().getFirst();
        testFigure(figure, topLeft, bottomRight);
    }

    // Tests that the right figure has been created in the area defined by the
    // initial and end points.
    protected abstract void testFigure(Figure figure, Point topLeft, Point bottomRight);

    @Test
    void testCreationUpRight() {
        tool.clickedOn(100, 200);
        tool.movedTo(132, 118);
        tool.releasedOn(300, 100);
        assertEquals(1, editor.drawing().figures().size());
        Figure figure = drawing.figures().getFirst();
        testFigure(figure, topLeft, bottomRight);
    }

    @Test
    void testCreationUpLeft() {
        tool.clickedOn(300, 200);
        tool.movedTo(132, 118);

        tool.releasedOn(100, 100);
        assertEquals(1, editor.drawing().figures().size());
        Figure figure = drawing.figures().getFirst();
        testFigure(figure, topLeft, bottomRight);
    }

    @Test
    void testCreationDownLeft() {
        tool.clickedOn(300, 100);
        tool.movedTo(132, 118);

        tool.releasedOn(100, 200);
        assertEquals(1, editor.drawing().figures().size());
        Figure figure = drawing.figures().getFirst();
        testFigure(figure, topLeft, bottomRight);
    }

    @Test
    void testNoReleaseWithoutClick() {
        tool.releasedOn(300, 200);
        // No figure has been created
        assertTrue(drawing.figures().isEmpty());
        // Now, selection tool should be active
        assertTrue(editor.currentTool() == editor.defaultTool());
        assertTrue(editor.currentTool() instanceof SelectionTool);
    }
}
