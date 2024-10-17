package editor.tools.figures;

import editor.core.*;
import editor.figures.Triangle;

public class TriangleCreationTool implements Tool {

    private Editor editor;
    private int numberOfVertices;
    private Point[] vertices = new Point[3];

    public TriangleCreationTool(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void reset() {
        numberOfVertices = 0;
        vertices = new Point[3];
    }

    @Override
    public void clickedOn(int x, int y) {
        vertices[numberOfVertices++] = new Point(x, y);
        if (numberOfVertices == 3) {
            Figure triangle = new Triangle(vertices[0], vertices[1], vertices[2]);
            editor.drawing().addFigure(triangle);
            editor.toolDone();
        }
    }

    @Override
    public void movedTo(int x, int y) {
        // It has no effect while creating a triangle
    }

    @Override
    public void releasedOn(int x, int y) {
        // It has no effect while creating a triangle
    }
}
