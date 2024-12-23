package com.ecom.controller;

import java.beans.Customizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqSoftDeleteDTO;
import com.ecom.dto.ProductsReqDTO;
import com.ecom.pojo.User;
import com.ecom.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	public ProductController() {
		System.out.println("inside productController");
	}
	
//	1. Admin should be able to add a product
	@PostMapping
	ResponseEntity<?> addProducts(@RequestBody ProductsReqDTO productDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProducts(productDto));	
	}
	
//	2. Admin should be able to delete product (soft delete)
	@GetMapping
	public ResponseEntity<?> getProductById(@RequestParam Long productId) {
		return ResponseEntity.ok(productService.getAvlProducts()) ;
	}
	@DeleteMapping
	public ResponseEntity<?> deleteProduct(@RequestParam Long productId, @RequestBody ProductReqSoftDeleteDTO productReqSoftDeleteDTO ){
		return ResponseEntity.ok(productService.deleteProduct(productId, productReqSoftDeleteDTO));
	}
	
		
//	3. Customer should be able to view all available products.
	@GetMapping("/{customerID}")
	public ResponseEntity<?> getAllProducts(Long customerID) {
		return ResponseEntity.ok(productService.getProducts(customerID));
	}
	
}
