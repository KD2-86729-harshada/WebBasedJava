package com.ecom.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class ProductsReqDTO {
	private String productName;
	private String description;
	private double pPrice;
	private int avlProducts;
	private boolean status;

	
	private Long adminId;
}