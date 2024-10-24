package commands;

import java.util.*;


public class EditorStack {

    private Stack<Command> undoList;
    private Stack<Command> redoList;

    public void addChange(Command command){
        undoList.push(command);
        redoList.clear();
    }

    public void undo(){
        if(undoList.empty()){
            System.out.println("No hay cambios para deshacer"); 
            return;
        }
        Command undoCommand = undoList.pop();
        undoCommand.undo();
        redoList.push(undoCommand);
    }

    public void redo(){
        if(redoList.empty()){
            System.out.println("No hay cambios para rehacer"); 
            return;
        }
        Command redoCommand = redoList.pop();
        redoCommand.undo();
        undoList.push(redoCommand);
    }
}
