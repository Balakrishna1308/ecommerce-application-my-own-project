
package com.bala.ecommerce.application.myownproject.validation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = OnlyStringConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyString
{
	public String message() default "Only strings are allowed.";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}
