package com.hibernatebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateEagervsLazy {

	public static void main(String[] args) {
		
		//Creating session factory
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		System.out.println("Session factory created");
		//Create Session using the session factory
		Session session = factory.getCurrentSession();
		
		System.out.println("Session Created");
		
		try {
			
			//Begin transaction
			session.beginTransaction();
			
			System.out.println("Getting values from DB");
			
			Instructor temp = session.get(Instructor.class, 1);
			
			System.out.println("instructor table "+ temp);
			
			session.getTransaction().commit();
			//closing the session so that the lazy loading throws error
			
			session.close();
			
			System.out.println("Course table" + temp.getCourses());
			
			
			
			
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
