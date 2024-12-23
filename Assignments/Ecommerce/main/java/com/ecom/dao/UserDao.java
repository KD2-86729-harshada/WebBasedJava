package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.pojo.User;

public interface UserDao extends JpaRepository<User, Long>{
	
}
