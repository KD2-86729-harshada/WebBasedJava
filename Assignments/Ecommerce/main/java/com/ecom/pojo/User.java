package com.ecom.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // mandatory class level annotation for hibernate , to specify
//following class represents DB entity
@Table(name = "users") // to specify name of the table
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = {"listOrders"})

public class User extends BaseEntity {

	@Column(name = "first_name", length = 20) // column name , varchar(20)
	private String firstName;
	
	@Column(name = "last_name", length = 20) // column name , varchar(20)
	private String lastName;
	
	@Column(length = 25, unique = true) // adds unique constraint
	private String email;
	
	@Column(length = 20, nullable = false) // not null constraint
	private String password;
	
	private LocalDate dob;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column(length = 30) // varchar(30)
	private UserRole role;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Orders> listOrders = new ArrayList<>();

	public User(String firstName, String lastName, String email, String password, LocalDate dob, boolean isActive,
			UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.isActive = isActive;
		this.role = role;
	} 
	
	
}

