package forms.validators;

import forms.Validator;

public class TextValidator implements Validator {
    
    public boolean isValid(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }

    public String getMessage() {
        return "solo letras";
    }
}
