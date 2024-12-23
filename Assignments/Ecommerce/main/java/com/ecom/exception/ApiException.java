package com.ecom.exception;

import com.ecom.dto.ApiResponse;

public class ApiException extends ApiResponse {

	public ApiException(String message) {
		super(message);
	}

}
