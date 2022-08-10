package com.bala.ecommerce.application.myownproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bala.ecommerce.application.myownproject.entity.Product;
import com.bala.ecommerce.application.myownproject.exception.ResourceNotFoundException;
import com.bala.ecommerce.application.myownproject.repository.ProductRepository;
import com.bala.ecommerce.application.myownproject.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService
{
   
	private ProductRepository productRepository;	
	
	@Override
	public Product saveProduct(Product product)
	{
	   return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id)
	{		

		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
	}

	@Override
	public Product updateProduct(Product product, long id)
	{
		Product exhistingProduct = productRepository.findById(id).orElseThrow
				(
				  () -> new ResourceNotFoundException("Product", "id", id)						
				);
		exhistingProduct.setProductDateCreated(product.getProductDateCreated());
		exhistingProduct.setProductDescription(product.getProductDescription());
		exhistingProduct.setProductLastUpdated(product.getProductLastUpdated());
		exhistingProduct.setProductName(product.getProductName());
		exhistingProduct.setProductPrice(product.getProductPrice());
		exhistingProduct.setProductStorageKeepingUnit(product.getProductStorageKeepingUnit());
		
		productRepository.save(exhistingProduct);
		return exhistingProduct;
	}

	@Override
	public void deleteProduct(long id)
	{
		productRepository.findById(id).orElseThrow
		(
		  () -> new ResourceNotFoundException("Product", "id", id)		
		);
		
		productRepository.deleteById(id);
	}

}
