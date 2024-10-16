package forms.validations;

import forms.Validator;

public class NumericField implements Validator {


	@Override
	public boolean validate(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
