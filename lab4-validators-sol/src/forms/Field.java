package forms;

import java.io.*;

import forms.validators.*;

public class Field {

	public static final Validator TEXT = new TextValidator();
	public static final Validator NUMBER = new NumberValidator();

	private String label;
	private String value;
	private Validator validator;

	public Field(String label, Validator validator) {
		this.label = label;
		this.validator = validator;
	}

	public String getValue() {
		return value;
	}

	public void askUser() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print(label + ": ");
				String userInput = console.readLine();
				if (validator.isValid(userInput)) {
					value = userInput;
					return;
				}
				System.out.println("Debe ser " + validator.getMessage());
			} catch (IOException e) {
				System.out.println("Se produjo un error al leer la entrada del usuario.");
			}
		}
	}
}
