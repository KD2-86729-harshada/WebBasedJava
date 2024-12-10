package com.cdac.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude ={"playerTeam"})
public class Players extends BaseEntity {
	
	@Column(length=20, name="p_fname")
	private String f_name;
	
	@Column(length=20, name="p_lname")
	private String l_name;
	
	private LocalDate dob;
	
	@Column(name = "bat_avg")
	private double batting_avg;
	
	@Column(name = "wict_taken")
	private int wickets_taken;
	
	@ManyToOne 
	@JoinColumn(name = "team_id")
	private Team playerTeam;
	
	public Players(String f_name, String l_name, LocalDate dob, double batting_avg, int wickets_taken) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.dob = dob;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
	}
	
}
