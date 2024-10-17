package forms.validators;

import forms.Validator;

public class NumberValidator implements Validator {

    public boolean isValid(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }

    public String getMessage() {
        return "un número";
    }
}
