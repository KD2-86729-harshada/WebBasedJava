package com.cdac.entities;

import javax.persistence.Entity;
import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "Team")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "players")
public class Team extends BaseEntity{
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column (name="team_id")
//	private Long teamId; 

	@Column (length=20 ,name="teamName")
	private String name;
	
	@Column (length=10 ,name="abv")
	private String abv;
	
	@Column (length=20 ,name="ownName")
	private String own_name;
	
	@Column (name="age")
	private int age;
	
	@Column (name="batAvg")
	private double bat_avg;
	
	@Column (name="wick")
	private int wickets;
	
	
	@OneToMany(mappedBy = "playerTeam", cascade = CascadeType.ALL, fetch=FetchType.EAGER,orphanRemoval = true)
	private java.util.List<Players> players = new ArrayList<Players>();
	
	public void addPlayer(Players player) {
		this.players.add(player);
		player.setPlayerTeam(this);
	}
	
	public void deletePlayers(Players player) {
		this.players.remove(player);
		player.setPlayerTeam(null);
		
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

	public Team(String abv, String own_name) {
		super();
		this.abv = abv;
		this.own_name = own_name;
	}

	
	

//	public Long getId() {
//		return teamId;
//	}
//
//	public void setId(long id) {
//		teamId = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAbv() {
//		return abv;
//	}
//
//	public void setAbv(String abv) {
//		this.abv = abv;
//	}
//
//	public String getOwn_name() {
//		return own_name;
//	}
//
//	public void setOwn_name(String own_name) {
//		this.own_name = own_name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public double getBat_avg() {
//		return bat_avg;
//	}
//
//	public void setBat_avg(double bat_avg) {
//		this.bat_avg = bat_avg;
//	}
//
//	public int getWickets() {
//		return wickets;
//	}
//
//	public void setWickets(int wickets) {
//		this.wickets = wickets;
//	}
//
//	@Override
//	public String toString() {
//		return "Team [teamId=" + teamId + ", name=" + name + ", abv=" + abv + ", own_name=" + own_name + ", age=" + age
//				+ ", bat_avg=" + bat_avg + ", wickets=" + wickets + "]";
//	}

}
