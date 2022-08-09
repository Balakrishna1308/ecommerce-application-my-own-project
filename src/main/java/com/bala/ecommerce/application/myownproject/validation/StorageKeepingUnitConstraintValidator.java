package com.bala.ecommerce.application.myownproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StorageKeepingUnitConstraintValidator implements ConstraintValidator<NotLeadingOrTrailingSpaces, String>
{
   	
	@Override
	public void initialize(NotLeadingOrTrailingSpaces notLeadingOrTrailingSpaces)
	{
		
	}	
	
	@Override
	public boolean isValid(String storageKeepingUnitField, ConstraintValidatorContext context)
	{
		return !(storageKeepingUnitField.startsWith(" ")||storageKeepingUnitField.endsWith(" "));
	}
		
}
