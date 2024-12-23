package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse addNewUser(UserReqDto userDto) {
		User userEntity = modelMapper.map(userDto, User.class);
		User userPersistent = userDao.save(userEntity);

		return new ApiResponse("User added successfully : "+userPersistent.getId());
	}

	

}
