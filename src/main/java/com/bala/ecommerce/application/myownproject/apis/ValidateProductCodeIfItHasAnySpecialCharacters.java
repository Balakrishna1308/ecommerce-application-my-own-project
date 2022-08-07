package com.bala.ecommerce.application.myownproject.apis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
public interface ValidateProductCodeIfItHasAnySpecialCharacters
{
	boolean validateIfProductCodeHasSpecialCharacters(String productCode);
	
	public static boolean testIfTheProductHasSpecialCharacters(String input)
	{
		{
			boolean val = false;
			Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern.matcher(input);
			val = match.find();	
			if (val)
			{return val;}		
				
			return val;	
		}
	}

}
