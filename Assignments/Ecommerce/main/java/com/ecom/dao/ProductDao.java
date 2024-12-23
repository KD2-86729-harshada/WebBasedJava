package com.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.pojo.Products;

public interface ProductDao extends JpaRepository<Products, Long>{

	List<Products> findByStatusTrue();
	
}
