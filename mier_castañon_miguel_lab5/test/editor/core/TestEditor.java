package editor.core;

import editor.tools.SelectionTool;
import editor.tools.figures.*;

public class TestEditor extends Editor {

    // Tools names
    public static final String SELECTION = "selection";
    public static final String RECTANGLE = "rectangle";
    public static final String CIRCLE = "circle";
    public static final String TRIANGLE = "triangle";

    @Override
    protected Tool createDefaultTool() {
        Tool defaultTool = new SelectionTool(drawing());
        addTool(SELECTION, defaultTool);
        return defaultTool;
    }

    @Override
    protected void createTools() {
        addTool(RECTANGLE, new RectangleCreationTool(this));
        addTool(CIRCLE, new CircleCreationTool(this));
        addTool(TRIANGLE, new TriangleCreationTool(this));
    }
}
