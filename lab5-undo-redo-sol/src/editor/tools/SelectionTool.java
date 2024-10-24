package editor.tools;

import editor.actions.MoveAction;
import editor.core.*;

public class SelectionTool implements Tool {

    private History history;
    private Drawing drawing;
    private Figure figure;
    private Point start;
    private Point lastPosition;

    public SelectionTool(Editor editor) {
        drawing = editor.drawing();
        history = editor.history();
    }

    @Override
    public void reset() {
        figure = null;
        start = lastPosition = null;
    }

    @Override
    public void clickedOn(int x, int y) {
        figure = drawing.findFigureAt(x, y);
        if (figure != null)
            start = lastPosition = new Point(x, y);
    }

    @Override
    public void movedTo(int x, int y) {
        if (!isDragging())
            return;
        move(x, y);
    }

    @Override
    public void releasedOn(int x, int y) {
        if (!isDragging())
            return;
        move(x, y);        
        // Add the total move to the history, without executing it
        history.add(new MoveAction(figure, lastPosition.x() - start.x(), lastPosition.y() - start.y()));
        reset();
    }

    private void move(int x, int y) {    
        figure.moveBy(x - lastPosition.x(), y - lastPosition.y());
        lastPosition = new Point(x, y);
    }

    private boolean isDragging() {
        return figure != null;
    }
}
