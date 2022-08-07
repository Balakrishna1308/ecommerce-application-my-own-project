package com.bala.ecommerce.application.myownproject.apis;

import java.util.Optional;

@FunctionalInterface
public interface TrimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces
{
	String trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces(String productName);
	
	public static String trimTheProductNameIfItHasAnyLeadingOrTrailingSpaces(String productName)
	{
		Optional<String> productNameOptional = Optional.ofNullable(productName);
		String trimmedProductCode = productNameOptional.map((productCode) -> productCode.trim()).get();
		return trimmedProductCode;								
	}

}
