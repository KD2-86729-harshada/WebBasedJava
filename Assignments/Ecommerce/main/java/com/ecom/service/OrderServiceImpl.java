package com.ecom.service;

import com.ecom.dao.OrderDao;
import com.ecom.dto.ApiResponse;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;

	@Override
	public ApiResponse placeOrders(Long productID, Long customerID, int quantity) {
		
		= orderDao.save();
		return null;
	}

}
