package editor.tools.figures;

import editor.core.*;
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
