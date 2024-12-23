package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqSoftDeleteDTO;
import com.ecom.dto.ProductsReqDTO;
import com.ecom.pojo.Products;

public interface ProductService {

	ApiResponse addNewProducts(ProductsReqDTO productDto);

	List<Products> getAvlProducts();

	ApiResponse deleteProduct(Long productId, ProductReqSoftDeleteDTO productReqSoftDeleteDTO);

	List<Products> getProducts(Long customerID);	
}
