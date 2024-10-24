package editor.actions;

import editor.core.*;

public class MoveAction implements Action {

    private Figure figure;
    private int dx;
    private int dy;

    public MoveAction(Figure figure, int dx, int dy) {
        this.figure = figure;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        figure.moveBy(dx, dy);
    }

    @Override
    public void undo() {
        figure.moveBy(-dx, -dy);
    }
}
