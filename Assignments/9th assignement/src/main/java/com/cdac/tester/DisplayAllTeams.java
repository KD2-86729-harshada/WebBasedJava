package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;;

public class DisplayAllTeams {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			TeamDao teamdao = new TeamDaoImpl();
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
