package com.bala.ecommerce.application.myownproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bala.ecommerce.application.myownproject.apis.ValidateSpecialCharacters;

public class NotSpecialCharacterConstraintValidator implements ConstraintValidator<NotSpecialCharacter, String>
{

		@Override
		public void initialize(NotSpecialCharacter notSpecialCharacter)
		{
			
		}	
		
		@Override
		public boolean isValid(String inputStringField, ConstraintValidatorContext context)
		{
		   ValidateSpecialCharacters validateSpecialCharacters =
		   ValidateSpecialCharacters::doesInputHaveSpecialCharacters;
		   
		   return !validateSpecialCharacters.validateSpecialCharacters(inputStringField);			
		}	
		
	}

