package editor.tools.figures;

import editor.core.Area;
import editor.core.Editor;
import editor.core.Figure;
import editor.figures.Rectangle;
import editor.tools.AbstractCreationTool;

public class RectangleCreationTool extends AbstractCreationTool {
    
    public RectangleCreationTool(Editor editor) {
        super(editor);
    }

    @Override
    protected Figure createFigure(Area bounds) {
        return new Rectangle(bounds);
    }
}
