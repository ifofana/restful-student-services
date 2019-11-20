package com.ia.restfulstudentservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ia.restfulstudentservices.model.Contact;
import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.StudentRepository;

@SpringBootApplication
public class RestfulStudentServicesApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(RestfulStudentServicesApplication.class);
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(RestfulStudentServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * // Create a new Student SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy MMM dd HH:mm:ss"); Calendar calendar = new
		 * GregorianCalendar(2014,04,29); Student student = new Student("SystemTest",
		 * "Raja", "M.", "Bell", calendar.getTime(), 0, "Male", "cats",
		 * "Foundition - 5 & 6 years old", "Saturday");
		 * 
		 * // Create a new Contact Contact contact = new Contact("SystemTest",
		 * "Mahamad Alhassane", "202.322.7474", null, "Mahamad.Alhassane@someemail.com",
		 * null, null);
		 * 
		 * // Set child reference(contact) in parent entity(student)
		 * student.setContact(contact);
		 * 
		 * // Set parent reference(student) in child entity(contact)
		 * contact.setStudent(student);
		 * 
		 * // Create a new Parent/Guardian ParentGuard guardian = new
		 * ParentGuard("SystemTest", "Fatimah Ali", "123 Main Street", "Suite 300",
		 * "McLean", "VA", "22102", "(757) 888-3322", null, "Fatimah_Ali@omali.org",
		 * null, "Aunty to Raja Bell");
		 * 
		 * // Set child reference (guardian) in parent entity(student)
		 * student.setParentGuard(guardian);
		 * 
		 * // Set parent reference(student) in child entity(guardian)
		 * guardian.setStudent(student);
		 * 
		 * // Save in database studentRepository.save(student);
		 */
		
	}

}
