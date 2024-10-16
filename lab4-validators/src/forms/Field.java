package forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Field {

	private String label;
	private Validator validator;
	private String text;

	public Field(String label, Validator validator){
		this.label = label;
		this.validator = validator;
	}


	void askUser(){
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print(label + ": ");
                text = consola.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!validator.validate(text));
	}

	String getValue(){
		return text;
	}
}
