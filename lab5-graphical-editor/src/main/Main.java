package main;

import java.io.*;
import java.util.List;

import editor.core.Editor;

public class Main {

	private static Editor editor;

	public static void main(String[] args) throws IOException {
		
		editor = new Editor();
		run();
	}

	// Simulates the interaction of the user with the editor. Note that it does
	// not represent the user interface itself (not even a text-based one), but
	// the system events that would be triggered by the graphical library when
	// the user interacts with the editor. Therefore, it is not part of the
	// editor's logic, and should remain in the main class as is.
	//
	private static void run() throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = System.out;

		showHelp(output);
		do {
			output.print("> ");
			output.flush();

			// Asks the user via console and splits the entered line into two 
			// parts: first, the name of the tool button that has been pressed,
			// the mouse action, or any other option; after that, the rest of
			// the line. For example:
			//
			// > click 100, 100 ---> tokens = [ "click", "100, 100" ]
			//
			String[] tokens = input.readLine().split(" ", 2);
			String action = tokens[0].trim();

			if (action.equals("salir")) {
				output.println("¡Adiós!");
				return;
			}

			//$ Mouse actions -----------------------------------

			if (action.equals("pulsar") || action.equals("mover") || action.equals("soltar")) {	
				try {					
					
					Point point = parseCoordinates(tokens[1]);
					
					if (action.equals("pulsar")) {
						editor.mousePressed(point.x, point.y);
					} else if (action.equals("mover")) {
						editor.mouseMoved(point.x, point.y);
					} else {
						editor.mouseReleased(point.x, point.y);
					}
				
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					output.println("Hacen falta las coordenadas del punto: <x>, <y>");
				}
				continue; 
			}

			if (editor.toolNames().contains(action)) {
				editor.toolButtonPressed(action);
			} else if (action.equals("dibujar")) {
				editor.draw();
			} else if (action.equals("ayuda")) {
				showHelp(output);
			} else {
				output.println("Acción desconocida");
				showHelp(output);
			}
		} while (true);
	}

	private static void showHelp(PrintStream output) {
		output.println("");
		output.println("Herramientas: " + showTools());
		output.println("Eventos del ratón: pulsar <x>, <y> - mover <x>, <y> - soltar <x>, <y>");
		output.println("Otras acciones: dibujar - ayuda - salir");
		output.println("---------------------------------------------------------------------");
	}

	private static String showTools() {
		List<String> toolNames = editor.toolNames();
		return String.join(" - ", toolNames);
	}

	// Receives a string with the coordinates of a point in the form "x, y" 
	// and returns a point. The coordinates can be separated by any number
	// of spaces before and after the comma.
	//
	private static Point parseCoordinates(String coordinates) {
		String[] arguments = coordinates.split("\\s*,\\s*");
		int x = Integer.parseInt(arguments[0]);
		int y = Integer.parseInt(arguments[1]);
		return new Point(x, y);
	}

	private record Point(int x, int y) {}
}
