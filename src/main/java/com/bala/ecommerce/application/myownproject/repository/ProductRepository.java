package com.bala.ecommerce.application.myownproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.ecommerce.application.myownproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
