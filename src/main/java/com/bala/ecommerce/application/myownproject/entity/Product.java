package com.bala.ecommerce.application.myownproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.bala.ecommerce.application.myownproject.validation.NotLeadingOrTrailingSpaces;
import com.bala.ecommerce.application.myownproject.validation.ProductCode;

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

public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Size(min = 8, max=25, message = "Product name must be between 8 and 25")
	private String productName;
	
	@ProductCode(value = "VUI", message = "product code must start with VUI")
	private String productCode;
	
	private String productDescription;
	private BigDecimal productPrice;
	
	@NotLeadingOrTrailingSpaces()	
	private String productStorageKeepingUnit;
	
	@Past(message = "Date must be past")
	private LocalDate productDateCreated;
	
	@Past(message = "Date must be past")
	private LocalDate productLastUpdated;
	
}
