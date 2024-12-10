package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Team;

import java.io.Serializable;

public class TeamDaoImpl implements TeamDao{

	@Override
	public String signUpTeam(Team team) {
		String msg = "Team registeration failed";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Serializable teamId = session.save(team);
			tx.commit();
			msg = "Team signed up!, Id"+ teamId;
		}
		catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
		}
		return msg;
	}

}
