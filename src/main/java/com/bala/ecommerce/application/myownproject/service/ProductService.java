package com.bala.ecommerce.application.myownproject.service;

import java.util.List;

import com.bala.ecommerce.application.myownproject.entity.Product;

public interface ProductService
{
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);
	Product updateProduct(Product product, long id);
	void deleteProduct(long id);
}
