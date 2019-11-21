package com.ia.restfulstudentservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ia.restfulstudentservices.model.Contact;
import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.ContactRepository;

@SpringBootApplication
public class RestfulStudentServicesApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(RestfulStudentServicesApplication.class);
	
	@Autowired private ContactRepository contactRepository;

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(RestfulStudentServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contact contact = new Contact();
		contact.setContactName("Ibrahima Fofana");
		contact.setContactRelationshipToStudent("Dad");
		contact.setContactPhoneNumber("240.498.7218");
		contact.setContactEmail("ibrahima.fofana.ia@gmail.com");
		contact.setContactAltPhoneNumber("301.540.6618");
		contact.setContactAltEmail("ifofana75@gmail.com");
		contact.setCreatedBy("SystemTest");
		contact.setCreatedOn(new Date());
		
		Student student1 = new Student();		
		student1.setFirstName("Jamil");
		student1.setMiddlename("I.");
		student1.setLastName("Fofana");
//		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar1 = new GregorianCalendar(2009,05,05);
		student1.setDob(calendar1.getTime());
		student1.setAge(10);
		student1.setGender("Male");
		student1.setAllerges("Tree-nuts products");
		student1.setClassDay("Saturday");
		student1.setClassSelection("intermediate");
		student1.setCreatedBy("SystemTest");
		student1.setCreatedOn(new Date());
		student1.setContact(contact);
		
		Student student2 = new Student();
		student2.setFirstName("Mariam");
		student2.setMiddlename("I.");
		student2.setLastName("Fofana");
		//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar2 = new GregorianCalendar(2012,11,28);
		student2.setDob(calendar2.getTime());
		student2.setAge(6);
		student2.setGender("Female");
		//student2.setAllerges("");
		student2.setClassDay("Saturday");
		student2.setClassSelection("foundtion");
		student2.setCreatedBy("SystemTest");
		student2.setCreatedOn(new Date());
		student2.setContact(contact);
		
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student1);
		studentSet.add(student2);
		
		ParentGuard pg = new ParentGuard();
		pg.setPgName("Aminata NDiaye");
		pg.setPgAddressOne("18930 Grotto Lane");
		pg.setPgCity("Germantown");
		pg.setPgState("Maryland");
		pg.setPgZipCode("20874");
		pg.setPgPhoneNumber("857.991.6529");
		pg.setPgEmail("ndiaye.aminata@gmail.com");
		pg.setPgAltEmail("firstami@hotmail.com");
		pg.setPgRelationshipToStudent("Step-Mother");		
		pg.setStudent(student1);
		
		Set<ParentGuard> pgSet = new HashSet<ParentGuard>();
		pgSet.add(pg);
		
		student1.setParentGuards(pgSet);
		contact.setStudents(studentSet);
		
		Contact contactCreated = contactRepository.save(contact);
		
	}

}
