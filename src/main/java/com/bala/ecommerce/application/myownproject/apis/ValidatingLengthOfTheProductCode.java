package com.bala.ecommerce.application.myownproject.apis;

@FunctionalInterface
public interface ValidatingLengthOfTheProductCode
{	
	int validateLengthOfTheProductCode(String productCode);	
	
	//code - 10111
	/*
	 * public static int testLengthOfTheProductCode(String productCode) { int
	 * lengthOfTheString = 0; if(productCode.length() == 10) {lengthOfTheString =
	 * 10;}
	 * 
	 * return lengthOfTheString; }
	 */
}
