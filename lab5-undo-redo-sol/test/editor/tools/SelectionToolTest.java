package editor.tools;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import editor.core.*;
import editor.figures.*;

public class SelectionToolTest {

    private Tool tool;

    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        Editor editor = new Editor();
        Drawing drawing = editor.drawing();
        tool = new SelectionTool(editor);
        rectangle = new Rectangle(new Point(100, 100), 300, 200);
        drawing.addFigure(rectangle);
    }

    @Test
    void testMove() {
        // Select the rectangle
        tool.clickedOn(125, 150);
        // Several moves
        // 75 pixels to the right, 50 pixels down
        tool.movedTo(200, 200);
        assertEquals(new Point(175, 150), rectangle.topLeft());
        // 100 pixels to the right, 30 pixels up
        tool.movedTo(300, 170);
        assertEquals(new Point(275, 120), rectangle.topLeft());
        // 200 pixels to the left, 150 pixels up
        tool.movedTo(100, 20);
        assertEquals(new Point(75, -30), rectangle.topLeft());
        // 50 pixels to the left, 100 pixels down
        tool.movedTo(50, 120);
        assertEquals(new Point(25, 70), rectangle.topLeft());
    }

    @Test
    void testMoveAfterRelease() {
        // Select the rectangle
        tool.clickedOn(125, 150);
        tool.movedTo(200, 200);
        assertEquals(new Point(175, 150), rectangle.topLeft());
        // Release the mouse
        tool.releasedOn(200, 200);
        assertEquals(new Point(175, 150), rectangle.topLeft());
        // This movement should not have any effect        
        tool.movedTo(300, 170);
        assertEquals(new Point(175, 150), rectangle.topLeft());
    }
}
