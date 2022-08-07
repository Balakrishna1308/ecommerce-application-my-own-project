package com.bala.ecommerce.application.myownproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bala.ecommerce.application.myownproject.exception.TestException;

public class StorageKeepingUnitConstraintValidator implements ConstraintValidator<NotLeadingOrTrailingSpaces, String>
{
   private String productStorageKeepingUnit; 
	
   
   @Override
	public void initialize(NotLeadingOrTrailingSpaces storageKeepingUnit)
	{
		productStorageKeepingUnit = storageKeepingUnit.value();
	}
   
   
   	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext)
	{
	    boolean result  = false;
	    
	    if(theCode.startsWith(" ")||theCode.endsWith(" "))
	    {
	    	result = true;
	    	theCode.trim();
	    	
	    }	    	
	    		    
	    return result;
	}   

}

//public class StorageKeepingUnitConstraintValidator 
//{
//   private String productStorageKeepingUnit; 
//	
//   	public boolean doesItHaveLeadingOrTrailingSpaces(String theCode)
//	{
//	    boolean result = false;
//	    
//	    if(theCode.startsWith("")||theCode.endsWith(""))
//	    {
//	    	throw new TestException();
//	    }	    	
//	    		    
//	    return result;
//	}   
//
//}
