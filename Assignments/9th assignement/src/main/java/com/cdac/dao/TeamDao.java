
package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Team;

public interface TeamDao {
	String signUpTeam(Team team);
	List<Team> getTeamDetails();
	List<Team> getMaxAgeAndMaxAvg(int maxAge, double batAvg);
	List<Team> getONameNAbv(int age, double batAvg);
	String UpdateMaxAge(String teamName, int maxAge);
	String deleteTeamDeatils(Long tId);
	Team displayTeamAndPlayersDeatils(Long teamId);
	
}
