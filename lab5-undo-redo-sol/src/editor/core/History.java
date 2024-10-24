package editor.core;

import java.util.*;

public class History {

    private Deque<Action> undoableActions = new ArrayDeque<>();
    private Deque<Action> redoableActions = new ArrayDeque<>();

    // Executes the given action and adds it to the history. Note that any
    // previous actions are removed from the history, since they cannot be
    // redone after a new action has been performed.
    //
    public void perform(Action action) {
        action.execute();
        add(action);
    }

    // Adds an action to the history without executing it.
    // 
    public void add(Action action) {
        undoableActions.push(action);
        redoableActions.clear();
    }

    public boolean canUndo() {
        return !undoableActions.isEmpty();
    }

    public void undo() {
        if (!canUndo())
            throw new IllegalStateException("No actions to undo");
        Action action = undoableActions.pop();
        action.undo();
        redoableActions.push(action);
    }

    public boolean canRedo() {
        return !redoableActions.isEmpty();
    }

    public void redo() {
        if (!canRedo())
            throw new IllegalStateException("No actions to redo");
        Action action = redoableActions.pop();
        action.execute();
        undoableActions.push(action);
    }
}
