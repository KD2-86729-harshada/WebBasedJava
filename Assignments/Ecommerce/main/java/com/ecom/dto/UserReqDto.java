package com.ecom.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.ecom.pojo.Orders;
import com.ecom.pojo.Products;
import com.ecom.pojo.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserReqDto {
	@NotEmpty
	@Length(min=1, max=20)
	private String firstName;
	
	@NotEmpty
	@Length(min=1, max=20)
	private String lastName;
	
	@NotEmpty
	@Length(min=1, max=20)
	@Email(message = "Invalid Email format")
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Password format invalid !!!!!")
	private String password;
	
	private LocalDate dob;

	@NotEmpty
	private UserRole role;
	
	private boolean isActive;
	
}
