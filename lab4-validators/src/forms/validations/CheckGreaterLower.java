package forms.validations;

import forms.Validator;

public class CheckGreaterLower implements Validator {

    private boolean greaterLower;
    private int valueToCheck;

    public CheckGreaterLower(boolean greaterLower, int valueToCheck){
        if (greaterLower) {
            this.greaterLower = true; // si es true, comprueba que sea mayor
        }
        else{
            this.greaterLower = false;
        }
        this.valueToCheck = valueToCheck;
    }

    @Override
    public boolean validate(String texto) {
        if(greaterLower){
            return valueToCheck > texto.length();
        }
        else{
            return valueToCheck < texto.length();
        }
    }

}
