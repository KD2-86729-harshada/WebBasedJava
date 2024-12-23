package com.ecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqSoftDeleteDTO;
import com.ecom.dto.ProductsReqDTO;
import com.ecom.exception.ApiException;
import com.ecom.exception.ResourceNotFoundException;
import com.ecom.pojo.Products;
import com.ecom.pojo.User;
import com.ecom.pojo.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
		
	@Autowired
	private ModelMapper modelMapper;
	
//	1. Admin should be able to add a product
	@Override
	public ApiResponse addNewProducts(@RequestBody ProductsReqDTO productDto) {
		//get user by its id 
		User user = userDao.findById(productDto.getAdminId())
						   .orElseThrow(()-> new ResourceNotFoundException("Invalid Admin Id"));
		
		if(user.getRole() == UserRole.ADMIN) {
			Products productsEntity = modelMapper.map(productDto, Products.class);
			Products persistenProduct = productDao.save(productsEntity);
			return new ApiResponse("Product added successfully : "+ persistenProduct.getId());
		}
		return new ApiException("You are not allowed to add product");
	}

//    2. Admin should be able to delete product (soft delete)
	@Override
	public List<Products> getAvlProducts() {
		return productDao.findByStatusTrue();
	}
	@Override
	public ApiResponse deleteProduct(Long productId, @RequestBody ProductReqSoftDeleteDTO productReqSoftDeleteDTO) {
		User user = userDao.findById(productReqSoftDeleteDTO.getAdminId())
				   .orElseThrow(()-> new ResourceNotFoundException("Invalid Admin Id"));
		if(user.getRole() == UserRole.ADMIN) {

			Products product = productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("Invalid productID"));
			product.setStatus(false);
			return new ApiResponse("Product deleted sucessfully");
		}
		return null;
		
		
	}

//	3. Customer should be able to view all available products.
	@Override
	public List<Products> getProducts(Long customerID) {
		
		User customer = userDao.findById(customerID).orElseThrow(()->new ResourceNotFoundException("Invalid productID"));
		
		if(customer.getRole() == UserRole.CUSTOMER) {
			return productDao.findAll();
		}
		return null;
	}

}
