package editor.actions;

import editor.core.*;

public class AddFigureAction implements Action {

    private Drawing drawing;
    private Figure figure;

    public AddFigureAction(Drawing drawing, Figure figure) {
        this.drawing = drawing;
        this.figure = figure;
    }

    @Override
    public void execute() {
        drawing.addFigure(figure);
    }

    @Override
    public void undo() {
        drawing.removeFigure(figure);
    }
}
