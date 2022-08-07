package com.bala.ecommerce.application.myownproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
       (name = "products",
        schema = "ecommerce_application"
       )
@JsonFilter(value = "ProductDynamicBeanFilter")
public class ProductEntityForDynamicFilter
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productDescription;
	private BigDecimal productPrice;
	private String productStorageKeepingUnit;
	private LocalDate productDateCreated;
	private LocalDate productLastUpdated;
	
}
