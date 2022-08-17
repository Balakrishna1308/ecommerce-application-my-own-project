package com.bala.ecommerce.application.myownproject.info;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.StreamingHttpOutputMessage;

public class AdditionalInformation
{
	
	public static void languageUsedInformationToBePrintedInTheConsoleOfTheEditor()
	{
		System.out.println("\n");
		Stream<String> streamOfString = Stream.of("J", "A", "V", "A");
		streamOfString.forEach(System.out::print);
	}
		
	
//	public static Stream<String> information()
//	{
//		Stream<String> streamOfString = Stream.of("J", "A", "V", "A");
//		return streamOfString;
//	}		
		
	public static List<String> languageUsedinformationToBePrintedAsAJsonBody()
	{
		Stream<String> streamOfString = Stream.of("J", "A", "V", "A");
		List<String> listOfStringElements = streamOfString.toList();	
		return listOfStringElements;
	}	
	
	
	public static void someOfTheToolsUsedInThisAppToBeDisplayedAtTheConsole()
	{
		System.out.println("\n");
		Collection<String > listOfSomeOfTheToolsUsedInThisApp = Arrays.asList("Postman Client", "Swagger", "Jira");
		Stream<String> streamOfString = listOfSomeOfTheToolsUsedInThisApp.stream();
		streamOfString.forEach(System.out::println);
	}
	
	public static Stream<String> someOfTheToolsUsedInThisAppp()
	{
		Collection<String> collectionOfToolsUsed = Arrays.asList("Postman Client", "Swagger", "Jira");
		Stream<String> listOfCollectionOfToolsUsed = collectionOfToolsUsed.stream();
		return listOfCollectionOfToolsUsed;		
	}
	
	
	public static void frameWorksUsedInThisAppToBeDisplayedAtTheConsoleOfTheEditor()
	{
		System.out.println("\n");		
		List<String > listOfFrameworks = Arrays.asList("Spring", "Spring Boot", "Hibernate");
		Stream<String> streamOfListOfFrameworks = listOfFrameworks.stream();
		streamOfListOfFrameworks.forEach(System.out::println);		
	}
	
	public static Stream<String> frameworksUsedInThisApp()
	{
		List<String> listOfFrameworks = Arrays.asList("Spring", "Spring Boot", "Hibernate");
		Stream<String> streamOfListOfFrameworks = listOfFrameworks.stream();
		return streamOfListOfFrameworks;
	}
	
}
