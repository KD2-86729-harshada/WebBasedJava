package com.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductReqSoftDeleteDTO {
	private boolean status;

	private Long adminId;
}
