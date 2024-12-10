package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class DisplayOnameAbv {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
		Scanner sc=new Scanner(System.in))
		{
			TeamDao teamdao = new TeamDaoImpl(); 
			System.out.println("Enter the max age and batting average");
			teamdao.getONameNAbv( sc.nextInt(), sc.nextDouble())
			.forEach(team->System.out.println(team.getOwn_name()+" "+team.getAbv()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
