package editor.tools.figures;

import editor.core.*;
import editor.figures.Circle;
import editor.tools.AbstractCreationTool;

public class CircleCreationTool extends AbstractCreationTool {
    
    public CircleCreationTool(Editor editor) {
        super(editor);
    }

    @Override
    protected Figure createFigure(Area bounds) {
        return new Circle(bounds);
    }
}
