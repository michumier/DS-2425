package editor.tools;

import editor.core.*;

public abstract class AbstractCreationTool implements Tool {

    private Editor editor;
    private Area bounds;

    protected AbstractCreationTool(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void reset() {
        bounds = null;
    }

    @Override
    public void clickedOn(int x, int y) {
        bounds = new Area(x, y);
    }

    @Override
    public void movedTo(int x, int y) {
        if (isDragging()) {
            bounds.resizeTo(x, y);
        }
    }

    private boolean isDragging() {
        return bounds != null;
    }

    @Override
    public void releasedOn(int x, int y) {
        // Does a release without a click make sense?
        if (!isDragging()) {
            editor.toolDone();
            return;
        }
        bounds.resizeTo(x, y);
        Figure newFigure = createFigure(bounds);
        editor.drawing().addFigure(newFigure);
        editor.toolDone();
    }

    protected abstract Figure createFigure(Area bounds);
}
