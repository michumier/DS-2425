package editor.tools;

import static org.junit.jupiter.api.Assertions.*;

import editor.core.*;
import editor.figures.Rectangle;
import editor.tools.figures.RectangleCreationTool;

class RectangleCreationToolTest extends AbstractCreationToolTest {

    @Override
    protected Tool createTool(Editor editor) {
        return new RectangleCreationTool(editor);
    }    

    @Override
    protected void testFigure(Figure figure, Point topLeft, Point bottomRight) {
        assertTrue(figure instanceof Rectangle);
        Rectangle rectangle = (Rectangle) figure;
        int width = bottomRight.x() - topLeft.x();
        int height = bottomRight.y() - topLeft.y();
        assertEquals(topLeft, rectangle.topLeft());
        assertEquals(width, rectangle.width());
        assertEquals(height, rectangle.height());
    }
}
