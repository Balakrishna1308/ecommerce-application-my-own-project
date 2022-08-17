package com.bala.ecommerce.application.myownproject.controller.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.ecommerce.application.myownproject.apis.messages.Message;
import com.bala.ecommerce.application.myownproject.apis.messages.MessageToTheDeveloper;
import com.bala.ecommerce.application.myownproject.apis.messages.MessagesToTheConsumer;

@RestController
@RequestMapping("/api/messages")
public class MessageController
{
	@GetMapping("/defaultMessage")
	public String getDefaultMessage()
	{
		Message message = new MessagesToTheConsumer();
		String defaultMessageToAll = message.defaultMessageToAll();
		return defaultMessageToAll;
	}
	
	@GetMapping("/staticMessageCalling")
	public String getStaticMessage()
	{
		String staticMessageToAll = Message.staticMessageToAll();
		return staticMessageToAll;		
	}
	
	@GetMapping("/staticMessageCallingWithMethodReference")
	public String getStaticMessageMesthodReference()
	{
		Message staticMessageToAll = Message::staticMessageToAll;
		String staticMessageToAllWithMethodRef = staticMessageToAll.message();
				
		return staticMessageToAllWithMethodRef;				
	}
	
	@GetMapping("/overriddenMessageForConsumer")
	public String getOverriddenMessageForConsumer()
	{
		Message messageToTheConsumer = new MessagesToTheConsumer();
		String overriddenMessageToTheConsumer = messageToTheConsumer.message();
		return overriddenMessageToTheConsumer;
	}
	
	@GetMapping("/overriddenMessageForDeveloper")
	public String getOverriddenMessageForDeveloper()
	{
		Message messageToTheDeveloper = new MessageToTheDeveloper();
		String overriddenMessageToTheDeveloper = messageToTheDeveloper.message();
		return overriddenMessageToTheDeveloper;
	}

}
