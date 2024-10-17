package main;

import forms.*;
import forms.validators.*;

import static forms.Field.*;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new Field("Nombre", TEXT));
		form.addField(new Field("Apellidos", TEXT));
		form.addField(new Field("Teléfono", NUMBER));
		Validator cities = new PredefinedValueValidator("Santander", "Oviedo", "Cádiz");
		form.addField(new Field("Ubicación", cities));

		// New fields

		form.addField(new Field("Código de producto", new LengthValidator(4)));
		Validator postalCode = new AndValidator(Field.NUMBER, new LengthValidator(5));
		form.addField(new Field("Código postal", postalCode));
		form.addField(new Field("Edad", new GreaterThanValidator(18)));
		form.addField(new Field("Sueldo", new AndValidator(new GreaterThanValidator(800), new LessThanValidator(1200))));
		form.addField(new Field("Ubicación", new OrValidator(cities, postalCode)));
		form.addField(new Field("Código de promoción", new OrValidator(Field.TEXT, new AndValidator(Field.NUMBER, new LengthValidator(3)))));

		form.askUser();
	}
}
