package com.cdac.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entities.Team;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Scanner;


public class DiaplayAllTeamsMaxAgeAndMaxAvg {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
		Scanner sc=new Scanner(System.in))
			 {
				TeamDao teamdao =new TeamDaoImpl();
				System.out.println("Enter the Max Age and Max Bating Average");
				teamdao.getMaxAgeAndMaxAvg((sc.nextInt()),sc.nextInt()).forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
