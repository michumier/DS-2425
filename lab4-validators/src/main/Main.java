package main;

import forms.*;
import forms.validations.CheckGreaterLower;
import forms.validations.CheckLong;
import forms.validations.NumericField;
import forms.validations.PredefinedField;
import forms.validations.TextField;
import forms.validations.composite.CheckAll;
import forms.validations.composite.CheckAny;

public class Main {

	public static void main(String[] args) { 
		Form form = new Form();

		form.addField(new Field("Nombre", new TextField()));
		form.addField(new Field("Apellido", new TextField()));
		form.addField(new Field("Teléfono", new NumericField()));
		form.addField(new Field("Ciudad",new PredefinedField("Santander", "Oviedo", "Cádiz")));

		form.addField(new Field("Código postal", new CheckAll(new NumericField(), new CheckLong(5))));

		form.addField(new Field("Edad", new CheckAll(new NumericField(), new CheckGreaterLower(true, 5)))); // Si es true comprueba mayor

		form.addField(new Field("Sueldo", new CheckAll(new NumericField(), new CheckGreaterLower(true, 800), 
			new CheckGreaterLower(false, 1200))));

		form.addField(new Field("Ubicación", new CheckAny(new PredefinedField("Santander", "Oviedo", "Cádiz"),
			new CheckAll(new NumericField(), new CheckLong(5)))));

		form.addField(new Field("Código promoción", new CheckAny(new TextField(), new CheckAll(new NumericField(), new CheckLong(3)))));

		form.askUser();
	}
}
