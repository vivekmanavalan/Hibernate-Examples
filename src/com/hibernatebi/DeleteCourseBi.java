package com.hibernatebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseBi {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		System.out.println("Session factory created");
		//Create Session using the session factory
		Session session = factory.getCurrentSession();
		
		System.out.println("Session Created");
		
		try {
			
			session.beginTransaction();
			
			System.out.println("getting values from DB to delete");
			Course temp = session.get(Course.class, 2);
			
			
			//Delete will only delete from the course table not from the instructor table because we did not cascade it
			session.delete(temp);
			
			System.out.println("Deleted Successfully");
			
			session.getTransaction().commit();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
