package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import com.cdac.entities.Players;
import com.cdac.entities.Team;

public class PlayersDaoImpl implements PlayersDao {

	public String signUpPlayers(Long teamId, Players newPlayers) {
		
		String mesg = "Player registration failed!!!!!!!!!!";
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			Team team = session.get(Team.class, teamId);
			if (team == null) {
	            System.out.println("Team with id="+ teamId +"does not found");
	        }
			
			team.addPlayer(newPlayers);
			
			tx.commit();
			
//			session.persist(newPlayers);
			mesg = "Player signed up ! , ID " + newPlayers.getId();
		} 
		catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		
			throw e;
		}
		return mesg;
	}
	@Override
	public String deletePlayersFromTeam(Long teamId, Long playerId) {
		String msg = "Deletion failed";
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			Players players = session.get(Players.class, playerId);
			if(team != null && players != null) {
				team.deletePlayers(players);
				msg = "Players Deleted successfully!!!";
				tx.commit();
			}
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}

		return msg;
	}

}
