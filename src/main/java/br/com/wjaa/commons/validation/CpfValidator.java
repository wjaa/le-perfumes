package br.com.wjaa.commons.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.wjaa.commons.utils.Utils;
import br.com.wjaa.commons.validation.annotation.Cpf;

public class CpfValidator implements ConstraintValidator<Cpf, String>{

	@Override
	public void initialize(Cpf constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Utils.isCpfValid(value);
	}

}
