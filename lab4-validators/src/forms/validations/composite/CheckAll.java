package forms.validations.composite;


import forms.Validator;

public class CheckAll implements Validator{

    private Validator[] checkAllList;

    public CheckAll(Validator... validators){
        this.checkAllList = validators;
    }

    @Override
    public boolean validate(String texto) {
        for(Validator v: checkAllList){
            if(!v.validate(texto)){
                return false;
            }
        }
        return true;
    }

    

}
