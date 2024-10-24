package editor.tools;

import static org.junit.jupiter.api.Assertions.*;

import editor.core.*;
import editor.figures.Circle;
import editor.tools.figures.CircleCreationTool;

class CircleCreationToolTest extends AbstractCreationToolTest {

    @Override
    protected Tool createTool(Editor editor) {
        return new CircleCreationTool(editor);
    }    

    @Override
    protected void testFigure(Figure figure, Point topLeft, Point bottomRight) {
        
        assertTrue(figure instanceof Circle);
        Circle circle = (Circle) figure;
        
        // If it is not a square, but a rectangular area, the circle must be
        // the largest one that fits in the rectangle (that is, the minimum
        // of the width and height will be used as the diameter), and it must
        // be centered in the middle, both horizontally and vertically. 
        int width = bottomRight.x() - topLeft.x();
        int height = bottomRight.y() - topLeft.y();
        int radius = Math.min(width, height) / 2;
        int centerX = (topLeft.x() + bottomRight.x()) / 2;
        int centerY = (topLeft.y() + bottomRight.y()) / 2;
        
        Point center = new Point(centerX, centerY);
        
        assertEquals(center, circle.center());
        assertEquals(radius, circle.radius());
    }
}
