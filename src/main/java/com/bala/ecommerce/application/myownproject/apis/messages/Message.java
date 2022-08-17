package com.bala.ecommerce.application.myownproject.apis.messages;

public interface Message
{

	String message();

	default String defaultMessageToAll()
	{
		return "Hey, if ever you face the problems accessing this application,"
				+ "pleaes refer to the documentation. Haave a nice day.";		
	}	
	
	static String staticMessageToAll()
	{
		return "Hey, this is a message - from the static method.";
	}

}
