package forms.validators;

import forms.Validator;

public class PredefinedValueValidator implements Validator {

    private String[] predefinedValues;
    private String message;

    public PredefinedValueValidator(String... predefinedValues) {
        this.predefinedValues = predefinedValues;
        message = buildMessage();
    }

    public boolean isValid(String value) {
        for (String predefinedValue : predefinedValues) {
            if (predefinedValue.equals(value))
                return true;
        }
        return false;
    }

    public String getMessage() {
        return message;
    }

    private String buildMessage() {
		StringBuilder result = new StringBuilder("uno de los valores siguientes: ");
		for (int i = 0; i < predefinedValues.length; i++) {
			result.append(predefinedValues[i]);
			if (i < predefinedValues.length - 2)
				result.append(", ");
			if (i == predefinedValues.length - 2)
				result.append(" o ");
		}
		return result.toString();	    
    }
}
