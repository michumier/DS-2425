package forms.validators;

import java.util.*;

import forms.Validator;

public abstract class CompoundValidator implements Validator {
	
	protected List<Validator> validators = new ArrayList<>();

	protected CompoundValidator(Validator... validators) {
		this.validators = Arrays.asList(validators);
	}
	
	public void addCondition(Validator validator) {
		validators.add(validator);
	}

	@Override
	public String getMessage() {		
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < validators.size(); i++) {
			result.append(validators.get(i).getMessage());
			if (i < validators.size() - 2)
				result.append(", ");
			if (i == validators.size() - 2)
				result.append(" " + getConjuction() + " ");
		}
		return result.toString();
	}
	
	protected abstract String getConjuction();
}
