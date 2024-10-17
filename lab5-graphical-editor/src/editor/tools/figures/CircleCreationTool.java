package editor.tools.figures;

import editor.core.Area;
import editor.core.Editor;
import editor.core.Figure;
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
