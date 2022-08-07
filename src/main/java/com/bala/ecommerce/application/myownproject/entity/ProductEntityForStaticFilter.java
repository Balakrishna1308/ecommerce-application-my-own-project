package com.bala.ecommerce.application.myownproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class ProductEntityForStaticFilter
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productDescription;
	
	@JsonIgnore
	private BigDecimal productPrice;
	
	@JsonIgnore
	private String productStorageKeepingUnit;
	
	@JsonIgnore
	private LocalDate productDateCreated;
	
	@JsonIgnore
	private LocalDate productLastUpdated;
	
	public ProductEntityForStaticFilter(Long productId, String productName, String productDescription, String productStorageKeepingUnit)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStorageKeepingUnit = productStorageKeepingUnit;
	}
	
		
	
}
