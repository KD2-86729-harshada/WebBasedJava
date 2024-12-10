package com.cdac.tester;

import org.hibernate.SessionFactory;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class TestHibernate {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory())
		{
			System.out.println("Hibernate is running!!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
