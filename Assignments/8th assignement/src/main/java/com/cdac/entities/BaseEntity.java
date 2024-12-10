package com.cdac.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@CreationTimestamp
	@Column(name="create_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name="update_on")
	private LocalDateTime updatedOn;
	
	
//	@Version	//used for optimistic locking
//	private int entityVersion;

}
