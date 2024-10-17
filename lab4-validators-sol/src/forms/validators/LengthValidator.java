package forms.validators;

import forms.Validator;

public class LengthValidator implements Validator {
	
	private int length;

	public LengthValidator(int length) {
		this.length = length;
	}
	
	@Override
	public boolean isValid(String value) {
		return value.length() == length;
	}

	@Override
	public String getMessage() {
		return "de longitud " + length;
	}
}