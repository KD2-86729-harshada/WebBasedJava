package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entities.Team;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class TeamRegister {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory())
		{
			Scanner sc = new Scanner(System.in);
			TeamDao teamdao = new TeamDaoImpl();
			
			System.out.println("Enter Team details - String Name, "
					+ "String abv, String own_name, int age, "
					+ "double bat_avg,  int wickets,\r\n");
			
			Team newTeam = new Team(sc.next(), sc.next(),sc.next(),
					sc.nextInt(),sc.nextDouble(),sc.nextInt());
			
			System.out.println(teamdao.signUpTeam(newTeam));		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
