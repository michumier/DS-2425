package editor.core;

import java.io.PrintWriter;
import java.util.*;

import editor.tools.SelectionTool;
import editor.tools.figures.*;

public class Editor {

	private Drawing drawing;
	private PrintWriter output; // Simulates the GUI widget for the drawing

	private Tool currentTool;
	private Tool defaultTool;
	private Map<String, Tool> toolbar = new HashMap<>();
	// The names of the tools to be shown in the status bar
	private Map<Tool, String> toolNames = new HashMap<>();
	
	public Editor() {
		this(new Drawing());
	}
	
	public Editor(Drawing drawing) {
		setDrawing(drawing);
		createDefaultTool("Selección");
		createTools();
		output = new PrintWriter(System.out, true);
	}

	public void draw() {
		// In a real application, this method would draw not only the
		// drawing, but also the menu, the toolbar, the status bar...
		drawing.draw(output);
		// Show the name of the current tool in the status bar
		output.print("Herramienta seleccionada: " + toolNames.get(currentTool));
		output.println();
	}

	//$ Tool methods ---------------------------------------

	protected void createDefaultTool(String name) {
		currentTool = defaultTool = new SelectionTool(drawing);
		addTool(name, defaultTool);
	}

	protected void createTools() {
		addTool("Rectángulo", new RectangleCreationTool(this));
		addTool("Círculo", new CircleCreationTool(this));
		addTool("Triángulo", new TriangleCreationTool(this));
	}

	protected void addTool(String name, Tool tool) {
		toolbar.put(name, tool);
		toolNames.put(tool, name);
	}

	public void toolDone() {
		selectTool(defaultTool);
	}

	public Tool currentTool() {
		return currentTool;
	}

	public Tool defaultTool() {
		return defaultTool;
	}
	
	//$ Drawing methods -----------------------------------
	
	public Drawing drawing() {
		return drawing;
	}
		
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}
		
    //$ UI methods ----------------------------------------

	public void toolButtonPressed(String toolName) {
		Tool tool = toolbar.get(toolName);
		if (tool == null)
			throw new IllegalArgumentException("Unknown tool: " + toolName);
		selectTool(tool);
	}

	private void selectTool(Tool tool) {
		currentTool.reset();
		currentTool = tool;
	}

	public void mousePressed(int x, int y) {
		currentTool.clickedOn(x, y);
	}

	public void mouseMoved(int x, int y) {
		currentTool.movedTo(x, y);
	}

	public void mouseReleased(int x, int y) {
		currentTool.releasedOn(x, y);
	}
}
