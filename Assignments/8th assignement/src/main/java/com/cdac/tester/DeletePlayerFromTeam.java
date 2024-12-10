package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.PlayersDao;
import com.cdac.dao.PlayersDaoImpl;

public class DeletePlayerFromTeam {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in))
				{
					PlayersDao playerDao = new PlayersDaoImpl(); 
					System.out.println("Enter team Id and playerid to delete: ");
					playerDao.deletePlayersFromTeam(sc.nextLong(), sc.nextLong());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
	}

}
