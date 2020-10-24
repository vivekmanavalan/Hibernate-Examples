package com.hibernatebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOnetoMany {

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
			System.out.println("Transaction begins");
			
			Instructor temp = new Instructor("vivek","vivek@gmail.com");
			
			InstructorDetail tempDetail = new InstructorDetail("paplu_youtube","Surfing");
			
			//We have inserted the detail table values in corresponding object and it join automatically
			temp.setInstructorDetail(tempDetail);
			
			System.out.println("Saving values in db");
			//session.save(temp);
			
			session.getTransaction().commit();
			
			System.out.println("Saved Successfully");
			
			
			//Adding courses to the instructor
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Adding course values in DB");
			//Here we are getting the instructor id to map with the course
			
			temp = session.get(Instructor.class, 2);
			
			Course courses = new Course("Reactjs");
			
			//It will automatically map the course_instructor_id column with instructor_id column check course.java class
			//Below is one way of doing it and another way is using the add method in the instructor
			courses.setInstructor(temp);
			
			//session.save(courses);
			
			session.getTransaction().commit();
			
			System.out.println("Added course successfully");
			
			//Another way to save the values in course
			System.out.println("Another way to save the values in the course");
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Adding values in course table");
			
			temp = session.get(Instructor.class, 3);
			
			Course course = new Course("SpringMVC");
			
			//Add method in the instructor class will insert the values in the set instructor method
			temp.add(course);
			
			//session.save(course);
			
			session.getTransaction().commit();
			System.out.println("Saved values in the course table successfully");
			
			
			System.out.println("Retrieving instructor and course");
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			temp = session.get(Instructor.class, 3);
			
			System.out.println(temp.getCourses());
			
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
