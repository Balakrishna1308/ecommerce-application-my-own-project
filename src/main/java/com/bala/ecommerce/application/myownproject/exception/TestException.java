package com.bala.ecommerce.application.myownproject.exception;

public class TestException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	
	public TestException() 
	{
		super();
	}


	public TestException(String message)
	{
		
		this.message = message;
		
	}
	
	
}
