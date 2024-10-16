package forms.validations;

import forms.Validator;

public class TextField implements Validator {

	@Override
	public boolean validate(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}
}
