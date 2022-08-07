package com.bala.ecommerce.application.myownproject.apis;

@FunctionalInterface
public interface ValidateTheProductNameIfItContainsAnyLeadingOrTrailingSpaces
{
	boolean trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces(String productName);
	
	public static boolean trimTheProductNameIfItHasAnyLeadingOrTrailingSpaces(String productName)
	{
		boolean result = false;
		
		if(productName.startsWith(" ")||productName.endsWith(" "))
		result = true;		
		
		return result;	
		
	}
}
