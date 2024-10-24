package commands.concretecommands;

import commands.Command;
import editor.core.Drawing;
import editor.core.Figure;

public class CreateCommands implements Command{

    private Drawing drawing;
    private Figure figure;

    public CreateCommands(Drawing drawing, Figure figure) {
        this.drawing = drawing;
        this.figure = figure;
    }

    @Override
    public void undo() {
        drawing.removeFigure(figure);
    }

    @Override
    public void redo() {
        drawing.addFigure(figure);
    }


}
