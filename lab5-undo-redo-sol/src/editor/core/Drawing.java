package editor.core;

import java.io.PrintWriter;
import java.util.*;

public class Drawing  {

	private List<Figure> figures = new LinkedList<>();
	
	public void addFigure(Figure figure) {
		figures.addFirst(figure);
	}

	public void removeFigure(Figure figure) {
		figures.remove(figure);
	}

	public List<Figure> figures() {
		return Collections.unmodifiableList(figures);
	}
	
	public void draw(PrintWriter output) {
		for (Figure figure : figures) {
			figure.draw(output);
		}
	}

	public Figure findFigureAt(int x, int y) {
		for (Figure figure : figures) {
			if (figure.contains(x, y))
				return figure;
		}
		return null;
	}
}
