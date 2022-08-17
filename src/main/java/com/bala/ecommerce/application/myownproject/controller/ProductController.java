package com.bala.ecommerce.application.myownproject.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.ecommerce.application.myownproject.apis.TrimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces;
import com.bala.ecommerce.application.myownproject.apis.ValidateSpecialCharacters;
import com.bala.ecommerce.application.myownproject.apis.ValidateTheProductNameIfItContainsAnyLeadingOrTrailingSpaces;
import com.bala.ecommerce.application.myownproject.apis.ValidatingLengthOfTheProductCode;
import com.bala.ecommerce.application.myownproject.entity.Product;
import com.bala.ecommerce.application.myownproject.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController
{
	@Autowired
	private MessageSource messageSource;
	
	private ProductService productService;
	
	
//	//Simple message to the customer
//	@GetMapping("/message/")
//	public String simpleMesageToTheConsumers()
//	{
//		MessageToTheConsumer messageToTheConsumer = new MessagesToTheCostomerImpl();
//		return messageToTheConsumer.defaultMessageToTheConsumer();
//	}	
	
	//Create saveProduct() REST end point
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)
	{
		ValidatingLengthOfTheProductCode validatingLengthOfTheProductCode = (input) -> input.length();
		int lengthOfTheProductCode = validatingLengthOfTheProductCode.validateLengthOfTheProductCode(product.getProductCode());		
		
		ValidateSpecialCharacters validateProductCode =
		(productCode) -> ValidateSpecialCharacters.doesInputHaveSpecialCharacters(productCode);
		boolean ifProductCodeHasSpecialCharacters = validateProductCode.validateSpecialCharacters(product.getProductCode());
				
		ValidateTheProductNameIfItContainsAnyLeadingOrTrailingSpaces trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces
		= ValidateTheProductNameIfItContainsAnyLeadingOrTrailingSpaces::trimTheProductNameIfItHasAnyLeadingOrTrailingSpaces;		
		boolean doesProductNameContainsLeadingOrTrailingZeros = trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces.trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces(product.getProductName());
		
		if((lengthOfTheProductCode != 10) || (ifProductCodeHasSpecialCharacters==true))
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		else if (doesProductNameContainsLeadingOrTrailingZeros) 		
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);		
			
	}
	
	
	@PostMapping("/withSolutions/")
	public ResponseEntity<Product> saveProductWithSolutions(@Valid @RequestBody Product product)
	{
		ValidatingLengthOfTheProductCode validatingLengthOfTheProductCode = (input) -> input.length();
		int lengthOfTheProductCode = validatingLengthOfTheProductCode.validateLengthOfTheProductCode(product.getProductCode());		
		
		ValidateSpecialCharacters validateProductCode =
		(productCode) -> ValidateSpecialCharacters.doesInputHaveSpecialCharacters(productCode);
		boolean ifProductCodeHasSpecialCharacters = validateProductCode.validateSpecialCharacters(product.getProductCode());
			
		TrimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces
		= TrimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces::trimTheProductNameIfItHasAnyLeadingOrTrailingSpaces;
		
		String trimmedProductCode = trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces.trimTheProductNameIfItContainsAnyLeadingOrTrailingSpaces(product.getProductName());
		product.setProductName(trimmedProductCode);
		
		if((lengthOfTheProductCode != 10) || (ifProductCodeHasSpecialCharacters==true))
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);	
			
	}
	
	
	//create getAllProducts() REST end point
	@GetMapping("/")
	public List<Product> retrieveAllProducts()
	{
		return productService.getAllProducts();
	}
	
	
	//Build get product by id REST end point
	@GetMapping("/{id}")
	public ResponseEntity<Product> retrieveProductById(@PathVariable("id") long productId)
	{
	   return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	//Build get product by id REST end point with link
	@GetMapping("/link-to-all-products/{id}")
	public EntityModel<Product> retrieveProductByIdWithLinkToResources(@PathVariable("id") long productId)
	{
	   //return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
		
		Product product = productService.getProductById(productId);
		
		//model object - of
		EntityModel<Product> modelOfProduct = EntityModel.of(product);
		
		//linkto Products
		WebMvcLinkBuilder linkToProducts =
				linkTo(methodOn(this.getClass()).retrieveAllProducts());
		
		//add - rel
		modelOfProduct.add(linkToProducts.withRel("all-products"));
		
		//return model
	    return modelOfProduct;
		
	}
	
	//Build delete product by id REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") long productId)
	{
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product deleted surccessfully", HttpStatus.OK);		
	}
	
	/*
	 * //Internationalized - first method
	 * 
	 * @GetMapping("/internationalized") public String productNameInternationalized
	 * (@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
	 * return messageSource.getMessage("code.product.name", null, "Default message",
	 * locale); }
	 */
	
	//Internationalized - second method
		@GetMapping("/internationalized")
		public String productNameInternationalized()
		{
			return messageSource.getMessage("code.product.name", null, 
											"Default message", LocaleContextHolder.getLocale());
		}
}
