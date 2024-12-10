package com.cdac.dao;

import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Players;
import com.cdac.entities.Team;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;

public class TeamDaoImpl implements TeamDao{

	@Override
	public String signUpTeam(Team team) {
		String msg = "Team registeration failed";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Serializable teamId = session.save(team);
			tx.commit();
			msg = "Team signed up!, Id" +teamId;
		}
		catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
		}
		return msg;
	}

	@Override
	public List<Team> getTeamDetails() {
		
		String jpql = "SELECT t FROM Team t";
		List<Team> teams = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return teams;
	}

	@Override
	public List<Team> getMaxAgeAndMaxAvg(int maxAge, double maxAvg) {

		List<Team> team = null;
		String jpql = "SELECT t FROM Team t WHERE t.age < :maxage and t.bat_avg > :bat_avg";
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx =  session.beginTransaction();
		
		try{
			team = session.createQuery(jpql,Team.class )
					.setParameter("maxage", maxAge)
					.setParameter("bat_avg", maxAvg)
					.getResultList();
			tx.commit();
		}
		catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return team;
	}

	@Override
	public List<Team> getONameNAbv(int age, double batAvg) {
		List<Team> team = null;
		String jpql = "SELECT new com.cdac.entities.Team(own_name, abv) FROM Team t WHERE t.age < :agee AND t.bat_avg > : batAvg";
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			team = session.createQuery(jpql, Team.class)
					.setParameter("agee",age)
					.setParameter("batAvg", batAvg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}

		return team;
	}

	@Override
	public String UpdateMaxAge(String teamName, int maxAge) 
	{
		Team team = null;
		String msg = "Failed to update data";
		
		String jpql = "SELECT t FROM Team t WHERE t.name = :tname";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.createQuery(jpql, Team.class)
					.setParameter("tname", teamName)
					.getSingleResult();
			
			team.setAge(maxAge);
//			session.evict(team);
			tx.commit();
			msg = "Sucessfully updated data!!";
		} 
		catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteTeamDeatils(Long tId) {
		Team team = null;
		String msg = "Deletion failed";
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			team = session.get(Team.class, tId);
			if(team != null) {
				session.delete(team);
				msg = "Record Deleted successfully!!!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}

		return msg;
	}

	@Override
	public Team displayTeamAndPlayersDeatils(Long teamId) {
		Team team = null;
	
		String jpql = "SELECT t FROM Team t left join fetch t.players WHERE t.id =:team_id";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			team = session.createQuery(jpql, Team.class)
			.setParameter("team_id", teamId)
			.getSingleResult();
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return team;
	}

	
	
}
