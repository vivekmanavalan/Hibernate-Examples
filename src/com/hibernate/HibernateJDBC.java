package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateJDBC {

	public static void main(String[] args) {

		// Only one session factory is created since it is a heavy object takes lot of
		// time and memory

		SessionFactory factory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Sample.class)
				.buildSessionFactory();

		System.out.println("Session factory created successfully....");
		// Getting the session from the factory
		Session session = factory.getCurrentSession();

		System.out.println("Session created successfully...");

		try {
			System.out.println("Transaction Begins...");
			// Beginning the transaction
			session.beginTransaction();

			// id is not inserted since it is auto incremented
			Sample s = new Sample("CMS", 21, "female");

			// Adding values to the database
			session.save(s);

			System.out.println("Values added successfully " + s);

			// Commiting the transaction

			// Need to commit all the time otherwise changes won't reflectNeed to commit all
			// the time otherwise changes won't reflect
			session.getTransaction().commit();

			// Retrieving all the Values from the database *********************************

			System.out.println("");

			System.out.println("Retreiving values from database...");
			// get the current session

			session = factory.getCurrentSession();

			// Begin transaction
			session.beginTransaction();

			// creating a list so that we can retrieve all the values from the database
			@SuppressWarnings("unchecked")
			List<Sample> ls = session.createQuery("from Sample").getResultList();

			for (int i = 0; i < ls.size(); i++) {
				System.out.println(" ");
				System.out.print("ID: " + ls.get(i).getId() + " ");
				System.out.print("Name: " + ls.get(i).getName() + " ");
				System.out.print("Age: " + ls.get(i).getAge() + " ");
				System.out.print("Gender: " + ls.get(i).getGender());
			}

			session.getTransaction().commit();

			// Fetching specific record from database
			// *****************************************
			System.out.println("");

			System.out.println("Retreiving single row from database...");
			// get the current session

			session = factory.getCurrentSession();

			// Begin transaction
			session.beginTransaction();

			// we can get specific record using where clause
			System.out.println("Fetching Specific record from the database");

			@SuppressWarnings("unchecked")
			List<Sample> ls_specificrecord = session.createQuery("from Sample s where s.name='tharun'").getResultList();

			for (int i = 0; i < ls_specificrecord.size(); i++) {
				System.out.println(" ");
				System.out.print("ID: " + ls_specificrecord.get(i).getId() + " ");
				System.out.print("Name: " + ls_specificrecord.get(i).getName() + " ");
				System.out.print("Age: " + ls_specificrecord.get(i).getAge() + " ");
				System.out.print("Gender: " + ls_specificrecord.get(i).getGender());
			}

			session.getTransaction().commit();

			// Updating Single Value in the database
			// ******************************************
			System.out.println("");

			System.out.println("Updating value in the database...");
			// get the current session

			session = factory.getCurrentSession();

			// Begin transaction
			session.beginTransaction();

			int id = 3;

			Sample sam = session.get(Sample.class, id);

			System.out.println("Name of to be updated record " + sam.getName());

			sam.setName("tinku");

			System.out.println("Updation Completed....");

			session.getTransaction().commit();

			// Updating Values based on a where
			// clause*******************************************
			System.out.println("");

			System.out.println("Updating specific value in the database...");
			// get the current session

			session = factory.getCurrentSession();

			// Begin transaction
			session.beginTransaction();

			session.createQuery("update Sample set gender='male' where name='miru'").executeUpdate();

			System.out.println("Updating specific values end");

			session.getTransaction().commit();

			
			  //Deleting Values based on a where clause******************************************* 
				System.out.println("");
			  
			  System.out.println("Deleting specific value in the database..."); 
			  //get the current session
			  
			  session = factory.getCurrentSession();
			  
			  //Begin transaction 
			  
			  session.beginTransaction();
			  
			  session.createQuery("delete from Sample where name='CMS'").executeUpdate();
			  
			  System.out.println("Deleting specific values end");
			  
			  
			  
			  session.getTransaction().commit();
			 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
