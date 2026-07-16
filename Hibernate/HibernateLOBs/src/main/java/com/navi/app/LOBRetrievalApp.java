package com.navi.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.navi.model.StudentInfo;



public class LOBRetrievalApp
{
	public static void main(String[] args)
	{

		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		FileInputStream fis = null;
		boolean flag = false;
		byte image[] = null;
		 FileReader reader = null;
		 char textFile[] = null;
		 FileOutputStream fos = null;
		 FileWriter writer = null;
		
		config = new Configuration();
		
		config.configure();
		
		
		sessionFactory = config.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		StudentInfo studentInfo = session.get(StudentInfo.class, 1);
		
		try 
		{
		   fos = new FileOutputStream("Java.JPG");
		   writer = new FileWriter("Java.txt");  
		   fos.write(studentInfo.getImage());
		   
		   writer.write(studentInfo.getTextFile());
		   
		   
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		 
		

		
	
		
		 finally
		{
			
			try 
			{
				fos.close();
				writer.close();

			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
					session.close();
			sessionFactory.close();
			
		}
	}

}
