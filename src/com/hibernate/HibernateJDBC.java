package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateJDBC {

	public static void main(String[] args) {
		
		//Only one session factory is created since it is a heavy object takes lot of time and memory
		
		SessionFactory factory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Sample.class)
				.buildSessionFactory();
		
		System.out.println("Session factory created successfully....");
		//Getting the session from the factory
		Session session = factory.getCurrentSession();
		
		System.out.println("Session created successfully...");
		
		try {
		System.out.println("Transaction Begins...");
		//Beginning the transaction
		session.beginTransaction();
		
		//id is not inserted since it is autoincremented
		Sample s = new Sample("miru",21,"female");
		
		//Adding values to the database
		session.save(s);
		
		System.out.println("Values added successfully "+ s);
		
		//Commiting the transaction
		session.getTransaction().commit();
		
		
		//Retrieving Values from the database
		
		System.out.println("");
		
		System.out.println("Retreiving values from database...");
		//get the current session
		
		session = factory.getCurrentSession();
		
		//Begin transaction
		session.beginTransaction();
		
		//creating a list so that we can retrieve all the values from the database
		@SuppressWarnings("unchecked")
		List<Sample> ls = session.createQuery("from Sample").getResultList();
		
		for(int i=0;i<ls.size();i++) {
			System.out.println(" ");
			System.out.print("ID: "+ls.get(i).getId()+" ");
			System.out.print("Name: "+ls.get(i).getName()+" ");
			System.out.print("Age: "+ls.get(i).getAge()+" ");
			System.out.print("Gender: "+ls.get(i).getGender());
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
