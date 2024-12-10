package com.cdac.tester;

import org.hibernate.*;

import com.cdac.dao.PlayersDao;
import com.cdac.dao.PlayersDaoImpl;
import com.cdac.entities.Players;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;


public class PlayerRegister {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()){
			
			Scanner sc = new Scanner(System.in);
			PlayersDao playerdao = new PlayersDaoImpl();
			System.out.println("Enter the Team id : ");
			Long teamId = sc.nextLong();
			
			System.out.println("Enter Players details - String FirstName, "+"String LastName"
					+ "LocalDate dob, "
					+ "double bat_avg,  int wickets taken,\r\n");
			Players newPlayers = new Players(sc.next(), sc.next(),LocalDate.parse(sc.next()), sc.nextDouble(),sc.nextInt());
			System.out.println(playerdao.signUpPlayers(teamId ,newPlayers)); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
