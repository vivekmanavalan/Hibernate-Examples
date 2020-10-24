package com.hibernateonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOnetoOne {

	public static void main(String[] args) {
		
		//Creating session factory
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		System.out.println("Session factory created");
		//Create Session using the session factory
		Session session = factory.getCurrentSession();
		
		System.out.println("Session Created");
		
		try {
			
			//Begin transaction
			session.beginTransaction();
			System.out.println("Transaction begins");
			
			Instructor temp = new Instructor("tharun","tinku");
			
			InstructorDetail tempDetail = new InstructorDetail("paplu","Playing");
			
			//We have inserted the detail table values in corresponding object and it join automatically
			temp.setInstructorDetail(tempDetail);
			
			System.out.println("Saving values in db");
			session.save(temp);
			
			session.getTransaction().commit();
			
			System.out.println("Saved Successfully");
			
			//Deleting values from the instructor table and it will automatically delete corresponding foreign key 
			//value in the instructor detail table
			
			/*
			 * session = factory.getCurrentSession();
			 * 
			 * session.beginTransaction();
			 * 
			 * //We get the specific value from the db temp = session.get(Instructor.class,
			 * 2); System.out.println("delete name"+ temp.getFirst_name()); System.out.
			 * println("Deleting specific value from Instructor table and it will automatically delete in the instructor detail table"
			 * ); //using the delete method we delete the record from both table
			 * //session.delete(temp);
			 * 
			 * session.getTransaction().commit();
			 * System.out.println("Deleted Successfully");
			 */
			
		}
		
		catch(Exception e ) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
