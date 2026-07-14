package com.navi.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.navi.model.Student;

public class LaunchDelete
{

	public static void main(String[] args) 
	{
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;	
		 
		try
		{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student st = new Student();
			st.setSid(3);
			st.setsName("Harsh");
			st.setsCity("Jaipur");
			
//			session.delete(st);
			session.remove(st);
			
			flag = true;
		}
		catch(HibernateException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}

	}

}
