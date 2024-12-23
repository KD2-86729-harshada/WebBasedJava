package com.ecom.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Orders extends BaseEntity{
	@Column(name = "order_name", unique = true, length = 30)
	private int quantity;
	private boolean status;
	private String orderDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private User customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Products products;

	public Orders(int quantity, boolean status, String orderDetails, User customer, Products products) {
		super();
		this.quantity = quantity;
		this.status = status;
		this.orderDetails = orderDetails;
		this.customer = customer;
		this.products = products;
	}

	
}
