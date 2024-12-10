package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class DeleteTeamDeatils {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory();
		Scanner sc = new Scanner( System.in)){
			
			TeamDao teamdao = new TeamDaoImpl();
			System.out.println("Enter the id to delete record : ");
			teamdao.deleteTeamDeatils(sc.nextLong());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
