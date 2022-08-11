package com.bala.ecommerce.application.myownproject.apis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
public interface ValidateSpecialCharacters
{
	boolean validateSpecialCharacters(String productCode);
	
	public static boolean doesInputHaveSpecialCharacters(String input)
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
