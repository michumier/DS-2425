package editor.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.figures.*;
import editor.actions.*;

class HistoryTest {

    private History history;
    private Drawing drawing;

    @BeforeEach
    void setUp() {
        history = new History();
        drawing = new Drawing();
    }

    @Test
    void testNothingToUndo() {
        assertFalse(history.canUndo());
    }

    @Test
    void testNothingToRedo() {
        assertFalse(history.canRedo());
    }

    @Test
    void testUndoAndRedo() {
        
        // Add a rectangle to the drawing
        Figure rectangle = new Rectangle(new Point(10, 10), 20, 10);
        Action action = new AddFigureAction(drawing, rectangle);
        history.perform(action);

        assertFalse(drawing.figures().isEmpty());
        assertTrue(drawing.figures().contains(rectangle));
        assertTrue(history.canUndo());
        assertFalse(history.canRedo());
        
        // Add a circle to the drawing
        Figure circle = new Circle(new Point(30, 30), 5);
        action = new AddFigureAction(drawing, circle);
        history.perform(action);

        assertEquals(2, drawing.figures().size());
        assertTrue(drawing.figures().contains(circle));
        assertFalse(history.canRedo());

        // Undo the last action
        history.undo();

        assertEquals(1, drawing.figures().size());
        assertFalse(drawing.figures().contains(circle));
        assertTrue(drawing.figures().contains(rectangle));
        assertTrue(history.canRedo());

        // Redo the last action
        history.redo();

        assertEquals(2, drawing.figures().size());
        assertTrue(drawing.figures().contains(circle));
        assertTrue(drawing.figures().contains(rectangle));
        assertFalse(history.canRedo());

        // Undo everything
        history.undo();
        history.undo();

        assertTrue(drawing.figures().isEmpty());
        assertFalse(history.canUndo());
    }

    @Test
    void testClearHistory() {
        // Add a rectangle to the drawing
        Figure rectangle = new Rectangle(new Point(10, 10), 20, 10);
        Action action = new AddFigureAction(drawing, rectangle);
        history.perform(action);
        // Undo the last action
        history.undo();
        // A new action is performed
        Figure circle = new Circle(new Point(30, 30), 5);
        action = new AddFigureAction(drawing, circle);
        history.perform(action);
        // There should not be actions to redo
        assertFalse(history.canRedo());
    }
}
