package com.bala.ecommerce.application.myownproject.apis;

public class ValidateInputValues
{
  public static boolean isItStringOnly(String productStorageKeepingUnit)
  {
	  boolean isStringOnly = true;
	  boolean isItNumber = false; 
	  
	  for(int i=0;i<productStorageKeepingUnit.length();i++)
	  {
		if(Character.isDigit(productStorageKeepingUnit.charAt(i)))
		{
			isItNumber = true;			  
		}			  
	  }
	  
	  if(ValidateProductCodeIfItHasAnySpecialCharacters.testIfTheProductHasSpecialCharacters(productStorageKeepingUnit)||
		isItNumber)
	  {
		  isStringOnly = false;		 
	  }
	  
	  return isStringOnly;	  
  }
	
}
