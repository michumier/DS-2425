package main;

import java.io.*;
import java.util.Arrays;

import editor.core.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Editor editor = new Editor();
		
		run(editor);
	}

	// Simula la interacción del usuario con el editor. Nótese que no
	// representa la interfaz de usuario en sí (ni siquiera una de texto),
	// sino los eventos del sistema que se lanzarían al interactuar el usuario
	// con el editor. Por tanto, no forma parte de la lógica del editor, y
	// debería permanecer aquí tal como está (no se espera que lo modifiquéis).
	//
	private static void run(Editor editor) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = System.out;

		showHelp(output);
		do {
			output.print("> ");
			output.flush();

			// Le pregunta al usuario por consola y separa la línea introducida
			// en dos partes: primero, el nombre de la herramienta que se ha
			// pulsado, la acción del ratón, o cualquier otra opción; después,
			// el resto de la línea. Por ejemplo:
			//
			// > pulsar 100, 100 ---> tokens = [ "pulsar", "100, 100" ]
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
					output.println("Error de sintaxis: se esperaban las coordenadas del punto: <x>, <y>");
				}
				continue; 
			}

			// Comprueba que el resto de acciones no tengan parámetros
			if (Arrays.asList(actions).contains(action) && tokens.length > 1) {
				output.printf("Error de sintaxis: %s no recibe parámetros\n", action);
				continue;
			}

			if (action.equals("seleccion")) {
				editor.toolButtonPressed("Selección");
			} else if (action.equals("rectangulo")) {
				editor.toolButtonPressed("Rectángulo");
			} else if (action.equals("circulo")) {
				editor.toolButtonPressed("Círculo");
			} else if (action.equals("triangulo")) {
				editor.toolButtonPressed("Triángulo");
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
		output.println("Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println("Acciones del ratón: pulsar <x>, <y> - mover <x>, <y> - soltar <x>, <y>");
		output.println("Otras opciones: dibujar - ayuda - salir");
		output.println("----------------------------------------------------------------------");
	}

	// Recibe una cadena con las coordenadas de un punto en la forma "x, y"
	// y devuelve un punto. Las coordenadas pueden estar separadas por
	// cualquier número de espacios antes y después de la coma.
	//
	private static Point parseCoordinates(String coordinates) {
		String[] arguments = coordinates.split("\\s*,\\s*");
		int x = Integer.parseInt(arguments[0]);
		int y = Integer.parseInt(arguments[1]);
		return new Point(x, y);
	}

	private record Point(int x, int y) {}

	private static String[] actions = { "seleccion", "rectangulo", "circulo", "triangulo", "dibujar", "ayuda", "salir" };
}
