package br.com.wjaa.commons.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.wjaa.commons.validation.CpfValidator;

@Constraint(validatedBy = CpfValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
	String message() default "Cpf Inválido";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
