package com.navi.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.navi.model.Student;


public class LaunchFirstApp 
{

	public static void main(String[] args) 
	{
		//Step 1 Configuration Object
		
		Configuration config = new Configuration();
		
        //Step 2 Configure hibernate.cfg.xml file to Configuration Object
		config.configure();
		
		//Step 3 Create SessionFactory Object
		 SessionFactory sessionFactory = config.buildSessionFactory();
		 
		//Step 4 Get the Session Object from Session Factory
		 Session session = sessionFactory.openSession();
		
	    //Step 5 Begin the Transaction Within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();	
		student.setSid(1);
		student.setsName("Rohan");
		student.setsCity("Bengaluru");
		
		
		//Step 6 Perform Operation
		session.save(student);
		
		//Step 7 Performing Transaction Operations
		transaction.commit();
		
		//Step 8 Close the Session
		session.close();
		
		
	}

}
