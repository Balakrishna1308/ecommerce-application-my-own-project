package com.bala.ecommerce.application.myownproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.ecommerce.application.myownproject.entity.ProductEntityForStaticFilter;

@RestController
@RequestMapping("/api/filtering")
public class ProductStaticFilteringController
{
	
	@GetMapping("/product")
	public ProductEntityForStaticFilter retrieveProductAfterFiltering()
	{
		return new ProductEntityForStaticFilter(10L, "Lepakshi Notebook", "It is a ruled note book", "Hyderabnad");		
	}
	
	@GetMapping("/list-of-products")
	public List<ProductEntityForStaticFilter> retrieveListOfProductsAfterFiltering()
	{
		return Arrays.asList(
				new ProductEntityForStaticFilter(10L, "Lepakshi Notebook", "It is a ruled note book", "Hyderabnad"),
				new ProductEntityForStaticFilter(20L, "Reynolds Ballpen", "It is a beautiful ball pen", "Hyderabnad"),
				new ProductEntityForStaticFilter(30L, "Nokia Mobile", "It is a basic mobile", "Hyderabnad"));
	}
	
}
