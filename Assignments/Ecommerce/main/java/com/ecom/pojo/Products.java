package com.ecom.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Products extends BaseEntity {
		
	@Column(name = "product_name", unique = true, length = 30)
	private String productName;
	
	@Column( length = 30)
	private String description;
	
	@Column(name = "p_price")
	private double pPrice;
	
	@Column(name = "avl_prducts")
	private int avlProducts;
	
	@Column(name = "status")
	private boolean status;

	public Products(String productName, String description, double pPrice, int avlProducts) {
		super();
		this.productName = productName;
		this.description = description;
		this.pPrice = pPrice;
		this.avlProducts = avlProducts;
	}

}	
