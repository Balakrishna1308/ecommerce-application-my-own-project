package com.bala.ecommerce.application.myownproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductCodeConstraintValidator implements ConstraintValidator<ProductCode, String>
{
	private String productPrefix;
	
	@Override
	public void initialize(ProductCode productCode)
	{
		productPrefix = productCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext)
	{
	    boolean result;
	    if(theCode != null)
	    {
	    	result = theCode.startsWith(productPrefix);
	    }
	    		    
	    else
	    {
	    	result = true;
	    }
	    
	    return result;
	}	
	
}
