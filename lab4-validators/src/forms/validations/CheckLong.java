package forms.validations;

import forms.Validator;

public class CheckLong implements Validator{

    private int longitudeToCheck;

    public CheckLong(int longitudeToCheck){
        this.longitudeToCheck = longitudeToCheck;
    }

    @Override
    public boolean validate(String texto) {
        return texto.length() >= longitudeToCheck;
    }

}
