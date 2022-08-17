package com.bala.ecommerce.application.myownproject.apis.messages;

public class MessagesToTheConsumer implements Message
{

	@Override
	public String message()
	{
		return "Hey consumer, happy accessing this application.";
	}
	
}
