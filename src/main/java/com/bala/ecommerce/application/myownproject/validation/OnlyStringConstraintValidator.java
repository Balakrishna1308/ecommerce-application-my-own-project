package com.bala.ecommerce.application.myownproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bala.ecommerce.application.myownproject.apis.ValidateInputValues;

public class OnlyStringConstraintValidator implements ConstraintValidator<OnlyString, String>
{

	@Override
	public void initialize(OnlyString onlyString)
	{
		
	}	
	
	@Override
	public boolean isValid(String storageKeepingUnitField, ConstraintValidatorContext context)
	{
		return ValidateInputValues.isItStringOnly(storageKeepingUnitField); 
	}

}
