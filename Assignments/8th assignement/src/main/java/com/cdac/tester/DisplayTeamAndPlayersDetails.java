package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entities.Team;

public class DisplayTeamAndPlayersDetails {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in))
				{
					TeamDao teamdao = new TeamDaoImpl(); 
					System.out.println("Enter team Id tp display deatils : ");
					Team team = teamdao.displayTeamAndPlayersDeatils(sc.nextLong());
					System.out.println(team);
					System.out.println("All posts: ");
					team.getPlayers().forEach(System.out::println);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
	}
}
