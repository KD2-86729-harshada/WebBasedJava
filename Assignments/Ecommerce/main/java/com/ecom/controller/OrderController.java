package com.ecom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private OrderService ordreService;
	
//	4. Customer should be able to place order for a specific product
	@PostMapping("/{productID}")
	ResponseEntity<?> placeOrder(@PathVariable Long productID, @RequestParam Long customerID, @RequestBody int quantity){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ordreService.placeOrders(productID, customerID, quantity));
	}
}
