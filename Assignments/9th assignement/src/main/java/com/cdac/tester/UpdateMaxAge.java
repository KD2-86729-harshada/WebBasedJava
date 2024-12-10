package com.cdac.tester;

import java.util.Scanner;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class UpdateMaxAge {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory();
		Scanner sc = new Scanner( System.in))
		{
			TeamDao teamdao = new TeamDaoImpl();
			System.out.println("Enter the team name and age you want to update");
			System.out.println(teamdao.UpdateMaxAge(sc.next(), sc.nextInt()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
