package editor.core;

public interface Tool {
    void clickedOn(int x, int y);
    void movedTo(int x, int y);
    void releasedOn(int x, int y);
    // Resets the tool to its initial state.
    void reset();
}
