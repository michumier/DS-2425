package poll;

import java.io.*;

public class TextUserInterface {

	public void fill(Poll poll) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Respuestas posibles: [sí] / [no]");

		while (true) {
			System.out.println();
			System.out.println(poll.getQuestion());
			System.out.print("> ");

			// Read the user's input (it doesn't check if the number of words is correct)
			String[] line = input.readLine().split(" ");

			if (line[0].equals("salir")) {
				System.out.println("Adiós!");
				return;
			}

			if (line[0].equals("sí")) {
				poll.incrementYeses();
			}
			if (line[0].equals("no")) {
				poll.incrementNos();
			}
		}
	}
}

