package commands.concretecommands;

import commands.Command;
import editor.core.Figure;

public class MoveCommands implements Command{

    private Figure figure;
    private int moveX, moveY;


    public MoveCommands(Figure figure, int moveX, int moveY) {
        this.figure = figure;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    @Override
    public void undo() {
        this.figure.moveBy(-moveX, -moveY);
    }

    @Override
    public void redo() {
        this.figure.moveBy(moveX, moveY);
    }

}
