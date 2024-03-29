package com.gp.annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorEmail  implements ConstraintValidator<EmailValidation, String> {
	 @Override
	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        if(value==null) return false;
	        if(value.contains(" ")) return false;
	        return value.matches("[\\w\\S]+[@]+[\\w\\S]+[.]+[\\w\\S]+");
	    }
}
