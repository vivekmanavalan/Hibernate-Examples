package com.hibernateonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOnetoOneBi {

	public static void main(String[] args) {
		
		//Creating session factory
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		System.out.println("Session factory created");
		//Create Session using the session factory
		Session session = factory.getCurrentSession();
		
		System.out.println("Session Created");
		
		try {
			
			//Deleting values from the instructor table and it will automatically delete corresponding foreign key 
			//value in the instructor detail table
			
			session.beginTransaction();		

			//Deleting Value only from the instructor table not from the instructor detail table
			//For this we need to change the instructor class
			System.out.println("Deleting Value only from the instructor table not from the instructor detail table");
			
			InstructorDetail tempDetails = session.get(InstructorDetail.class, 4);
			
			System.out.println("temp details"+ tempDetails.getGithub_account());
			
			//Breaking the bi-directional connection and setting null to the foreign key field
			tempDetails.getInstructor().setInstructorDetail(null);
			session.delete(tempDetails);
			
			session.getTransaction().commit();
			
			System.out.println("Deleted from Instructor detail alone successfully");
			
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
