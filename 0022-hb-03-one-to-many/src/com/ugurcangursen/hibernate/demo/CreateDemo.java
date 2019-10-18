package com.ugurcangursen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ugurcangursen.hibernate.demo.entity.Instructor;
import com.ugurcangursen.hibernate.demo.entity.InstructorDetail;
import com.ugurcangursen.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			// crate the objects
			Instructor tempInstructor = 
					new Instructor("Deneme", "Darby", "darby@luv2code.com");
					
			InstructorDetail tempinstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/deneme",
							"Luv 2 cos!!!");
			
			//associate the objects
			
			tempInstructor.setInstructorDetail(tempinstructorDetail);
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
			finally {
				factory.close();
			}
		
	}

}
