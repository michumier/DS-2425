package forms.validations;

import forms.Validator;

public class PredefinedField implements Validator {

	private String[] predefinedValues;

	public PredefinedField(String... prefefinedValues) {
		this.predefinedValues = prefefinedValues;
	}


	@Override
	public boolean validate(String texto) {
		for (String each : predefinedValues) {
			if (texto.equalsIgnoreCase(each)) {
				return true;
			}
		}
		return false;
	}
}
