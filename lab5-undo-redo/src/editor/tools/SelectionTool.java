package editor.tools;

import commands.concretecommands.MoveCommands;
import editor.core.Drawing;
import editor.core.Editor;
import editor.core.Figure;
import editor.core.Point;
import editor.core.Tool;

public class SelectionTool implements Tool {

    private Drawing drawing;
    private Figure figure;
    private Point lastPosition;
    private Editor editor;

    public SelectionTool(Editor editor) {
        this.drawing = editor.drawing();
    }

    @Override
    public void reset() {
        figure = null;
        lastPosition = null;
    }

    @Override
    public void clickedOn(int x, int y) {
        figure = drawing.findFigureAt(x, y);
        if (figure != null)
            lastPosition = new Point(x, y);
    }

    @Override
    public void movedTo(int x, int y) {
        move(x, y);
    }

    @Override
    public void releasedOn(int x, int y) {
        move(x, y); 
        editor.getEditorStack().addChange(new MoveCommands(figure, x, y));       
        reset();
    }

    private void move(int x, int y) {
        if (!isDragging())
            return;
        figure.moveBy(x - lastPosition.x(), y - lastPosition.y());
        lastPosition = new Point(x, y);
    }

    private boolean isDragging() {
        return figure != null;
    }
}
