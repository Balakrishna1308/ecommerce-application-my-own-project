package com.bala.ecommerce.application.myownproject.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ProductCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductCode
{
	public String value() default "IUV";
	public String message() default "must start with IUV";
	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}
