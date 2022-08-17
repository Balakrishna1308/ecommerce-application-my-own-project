package com.bala.ecommerce.application.myownproject.controller.addlinfo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.ecommerce.application.myownproject.info.AdditionalInformation;

@RestController
@RequestMapping("/api/addlinfo")
public class AdditionalInformationController
{
	@GetMapping("/languageUsedToBeDisplayedInTheConsole")
	public void getLanguageUsedToBeDisplayedInTheConsole()
	{
		AdditionalInformation.languageUsedInformationToBePrintedInTheConsoleOfTheEditor();				
	}
		
	
//	@GetMapping("/languageUsedInThisApp")
//	public Stream<String> getLanguageUsed()
//	{
//		Stream<String> information = AdditionalInformation.information();
//		return information;		
//	}
	
	@GetMapping("/languageUsedInThisApp")
	public List<String> getLanguageUsedToBeDisplayedAsAJsonBody()
	{
		List<String> listOfStrings = AdditionalInformation.languageUsedinformationToBePrintedAsAJsonBody();
		return listOfStrings;		
	}
	
	@GetMapping("/toolsUsedInThisAppToBeDisplayedAtTheConsoleOfTheEditor")
	public void getToolsUsedToBeDisplayedAsAtTheConsoleOfTheEditor()
	{
		AdditionalInformation.someOfTheToolsUsedInThisAppToBeDisplayedAtTheConsole();
	}

	@GetMapping("/toolsUsedInThisApp")
	public Stream<String> getToolsUsedInThisApp()
	{
		Stream<String> someOfTheToolsUsedInThisAppp = AdditionalInformation.someOfTheToolsUsedInThisAppp();
		return someOfTheToolsUsedInThisAppp;		
	}
	
	@GetMapping("/frameworksUsedInThisAppToBeDisplayedAtTheConsoleOfTheEditor")
	public void getFrameworksUsedInThisAppToBeDisplayedAtTheConsoleOftheEditor()
	{
		AdditionalInformation.frameWorksUsedInThisAppToBeDisplayedAtTheConsoleOfTheEditor();		
	}	
	
	@GetMapping("/frameworksUsedInThisApp")
	public Stream<String> getFrameworksUsedInThisApp()
	{
		Stream<String> frameworksUsedInThisApp = AdditionalInformation.frameworksUsedInThisApp();		
		return frameworksUsedInThisApp;
	}
	
}
