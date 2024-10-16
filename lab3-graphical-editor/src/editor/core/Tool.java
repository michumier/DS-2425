package editor.core;

public interface Tool {
    void clickedOn(int x, int y);
    void movedTo(int x, int y);
    void releasedOn(int x, int y);
    void reset();
}
