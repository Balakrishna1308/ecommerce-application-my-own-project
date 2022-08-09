package com.bala.ecommerce.application.myownproject.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = StorageKeepingUnitConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLeadingOrTrailingSpaces
{
	public String message() default "Do not enter either leading or trailing spaces";
	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}
