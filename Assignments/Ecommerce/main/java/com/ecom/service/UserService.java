package com.ecom.service;
  
import com.ecom.dto.ApiResponse; import com.ecom.dto.UserReqDto;
  
public interface UserService {
  
  ApiResponse addNewUser(UserReqDto userDto);
  
}
 