package com.cdac.entities;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long team_id; 

	private String name;
	private String abv;
	private String own_name;
	private int age;
	private double bat_avg;
	private int wickets;
	
	public Team() {
	}

	public Team( String name, String abv, String own_name, int age, double bat_avg,
			int wickets) {
		this.name = name;
		this.abv = abv;
		this.own_name = own_name;
		this.age = age;
		this.bat_avg = bat_avg;
		this.wickets = wickets;
	}
	

	public Long getId() {
		return team_id;
	}

	public void setId(long id) {
		team_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getOwn_name() {
		return own_name;
	}

	public void setOwn_name(String own_name) {
		this.own_name = own_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBat_avg() {
		return bat_avg;
	}

	public void setBat_avg(double bat_avg) {
		this.bat_avg = bat_avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Team [Id=" + team_id + ", name=" + name + " , abv=" + abv + ", own_name="
				+ own_name + ", age=" + age + ", bat_avg=" + bat_avg + ", wickets=" + wickets + "]";
	}
}
