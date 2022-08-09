package com.bala.ecommerce.application.myownproject.apis;

public interface MessageToTheConsumer
{
	default String defaultMessageToTheConsumer()
	{
		return "If you have not got desired result, please have a look in the documentation section. "
				+ "It might help you get your desired result.";
	}
}
