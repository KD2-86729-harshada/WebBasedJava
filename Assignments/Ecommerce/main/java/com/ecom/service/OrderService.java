package com.ecom.service;

import com.ecom.dto.ApiResponse;

public interface OrderService {

	ApiResponse placeOrders(Long productID, Long customerID, int quantity);
}
