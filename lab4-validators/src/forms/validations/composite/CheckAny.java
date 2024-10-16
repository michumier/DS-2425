package forms.validations.composite;

import forms.Validator;

public class CheckAny implements Validator{

    private Validator[] checkAnyList;

    public CheckAny(Validator... validators){
        this.checkAnyList = validators;
    }

    @Override
    public boolean validate(String texto) {
        for(Validator v: checkAnyList){
            if(v.validate(texto)){
                return true;
            }
        }
        return false;
    }

    

}

