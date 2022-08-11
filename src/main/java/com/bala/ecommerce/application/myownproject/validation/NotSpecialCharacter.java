package com.bala.ecommerce.application.myownproject.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NotSpecialCharacterConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotSpecialCharacter
{
	public String message() default "No special characters allowed.";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}
