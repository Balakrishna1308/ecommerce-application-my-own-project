package com.bala.ecommerce.application.myownproject.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.ecommerce.application.myownproject.entity.ProductEntityForDynamicFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/api/dynamic-filtering")
public class ProductDynamicFilteringController
{
	
	@GetMapping("/product")
	public MappingJacksonValue retrieveProductAfterFiltering()
	{
		//Initialize values to the bean properties - 1
		ProductEntityForDynamicFilter productDynamicBean = 
		new ProductEntityForDynamicFilter(10001L, "Reynolds Pen", "This is a ball point pen", 
		BigDecimal.ONE, "Hyderabad",  LocalDate.MIN, LocalDate.now());
		
		
		//Apply filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("productId", "productName", "productDescription", "productStorageKeepingUnit");
		
		//Assign id
		FilterProvider filters = new SimpleFilterProvider().addFilter("ProductDynamicBeanFilter", filter);		
		
		//Instantiate MappingJacksonValue and associate 1 object
		MappingJacksonValue mapping = new MappingJacksonValue(productDynamicBean);		
		
		//Set filter
		mapping.setFilters(filters);		
		
		//Return mapping object
		return mapping;			
	}
	
	@GetMapping("/list-of-products")
	public MappingJacksonValue listOfProductsAfterDynamicFiltering()
	{
	  //Initialize fields of Prodcut Bean - 1
		List<ProductEntityForDynamicFilter> listOfProducts = 
		Arrays.asList
		(
			new ProductEntityForDynamicFilter(10001L, "Reynolds Pen", "This is a ball point pen", 
						BigDecimal.ONE, "Hyderabad",  LocalDate.MIN, LocalDate.now()),
			
			new ProductEntityForDynamicFilter(10002L, "Lepakshi Notebook", "This is a ruled notebook", 
					BigDecimal.ONE, "Hyderabad",  LocalDate.MIN, LocalDate.now()),
		
			new ProductEntityForDynamicFilter(10003L, "Samsong Mobile", "This is an android touch mobile", 
					BigDecimal.ONE, "Bangalore",  LocalDate.MIN, LocalDate.now())		
        );
		
	  //Apply filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("productId", "productName", "productDescription", "productStorageKeepingUnit");
		
	  //Assign some id
		FilterProvider filters = new SimpleFilterProvider().addFilter("ProductDynamicBeanFilter", filter);
		
	  //Instantiate MappingJacksonValue and associate the object of 1	
		MappingJacksonValue mapping = new MappingJacksonValue(listOfProducts);
		
	  //Set filter
	    mapping.setFilters(filters);
		
	  //return mapping object	
	    return mapping;
	}
	
	
	
	/*
	 * @GetMapping("/list-of-products") public List<ProductEntityForStaticFilter>
	 * retrieveListOfProductsAfterFiltering() { return Arrays.asList( new
	 * ProductEntityForStaticFilter(10L, "Lepakshi Notebook",
	 * "It is a ruled note book", "Hyderabnad"), new
	 * ProductEntityForStaticFilter(20L, "Reynolds Ballpen",
	 * "It is a beautiful ball pen", "Hyderabnad"), new
	 * ProductEntityForStaticFilter(30L, "Nokia Mobile", "It is a basic mobile",
	 * "Hyderabnad")); }
	 */	
}
