package com.ia.restfulstudentservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.ia.restfulstudentservices.model.Employee;
import com.ia.restfulstudentservices.model.Employee_Address;
import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.ContactRepository;
import com.ia.restfulstudentservices.repository.EmployeeRepository;

@SpringBootApplication
public class RestfulStudentServicesApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(RestfulStudentServicesApplication.class);
	
	@Autowired private ContactRepository contactRepository;
	
	@Autowired private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(RestfulStudentServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contact contact = new Contact();
		contact.setContactName("Musa Fofana");
		contact.setContactRelationshipToStudent("Dad");
		contact.setContactPhoneNumber("240.498.7218");
		contact.setContactEmail("musa.fofana.ia@gmail.com");
		contact.setContactAltPhoneNumber("301.640.8888");
		contact.setContactAltEmail("mfofana@gmail.com");
		contact.setCreatedBy("SystemTest");
		contact.setCreatedOn(new Date());
		
		Student student1 = new Student();		
		student1.setFirstName("Aliou");
		student1.setMiddlename("I.");
		student1.setLastName("Fofana");
		Calendar calendar1 = new GregorianCalendar(2009,06,06);
		student1.setDob(calendar1.getTime());
		student1.setAge(13);
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
		Calendar calendar2 = new GregorianCalendar(2012,11,28);
		student2.setDob(calendar2.getTime());
		student2.setAge(6);
		student2.setGender("Female");
		student2.setAllerges("No allergies");
		student2.setClassDay("Saturday");
		student2.setClassSelection("foundtion");
		student2.setCreatedBy("SystemTest");
		student2.setCreatedOn(new Date());
		student2.setContact(contact);
		
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student1);
		studentSet.add(student2);
		
		ParentGuard pg1 = new ParentGuard();
		pg1.setPgName("Aminata NDiaye");
		pg1.setPgAddressOne("18930 Grotto Lane");
		pg1.setPgCity("Germantown");
		pg1.setPgState("Maryland");
		pg1.setPgZipCode("20874");
		pg1.setPgPhoneNumber("857.991.6529");
		pg1.setPgEmail("ndiaye.aminata@gmail.com");
		pg1.setPgAltEmail("firstami@hotmail.com");
		pg1.setPgRelationshipToStudent("Step-Mother");		
		pg1.setStudent(student1);
		
		ParentGuard pg3 = new ParentGuard();
        pg3.setPgName("Habi Fall");
        pg3.setPgAddressOne("7245 Grey Eagle Court");
        pg3.setPgCity("Germantown");
        pg3.setPgState("Maryland");
        pg3.setPgZipCode("20874");
        pg3.setPgPhoneNumber("321.567.8989");
        pg3.setPgEmail("Habi.Fall@gmail.com");
        pg3.setPgAltEmail("firsthabi@hotmail.com");
        pg3.setPgRelationshipToStudent("Aunty");		
        pg3.setStudent(student1);
        
        ParentGuard pg2 = new ParentGuard();
        pg2.setPgName("Binta Fall");
        pg2.setPgAddressOne("7245 Grey Eagle Court");
        pg2.setPgCity("Germantown");
        pg2.setPgState("Maryland");
        pg2.setPgZipCode("20874");
        pg2.setPgPhoneNumber("321.567.8989");
        pg2.setPgEmail("Binta.Fall@gmail.com");
        pg2.setPgAltEmail("first_binta@hotmail.com");
        pg2.setPgRelationshipToStudent("Cousin");		
        pg2.setStudent(student1);
		
		Set<ParentGuard> pgSet = new HashSet<ParentGuard>();
		pgSet.add(pg1);
		pgSet.add(pg2);
		pgSet.add(pg3);
		
		student1.setParentGuardians(pgSet);
		contact.setStudents(studentSet);
		
		Contact contactCreated = contactRepository.save(contact);
		
//		Employee employee = new Employee();
//        employee.setEmpName("JIP");
//        
//        Employee_Address employeeAddress1 = new Employee_Address();
//        employeeAddress1.setStreet("Street 1");
//        employeeAddress1.setCity("City 1");
//        employeeAddress1.setCountry("Country 1");
//        employeeAddress1.setState("State 1");
//        employeeAddress1.setEmployee(employee);
//        
//        
//        Employee_Address employeeAddress2 = new Employee_Address();
//        employeeAddress2.setStreet("Street 2");
//        employeeAddress2.setCity("City 2");
//        employeeAddress2.setCountry("Country 2");
//        employeeAddress2.setState("State 2");
//        employeeAddress2.setEmployee(employee);
//        
//        Set<Employee_Address> employeeAddressSet = new HashSet();
//        employeeAddressSet.add(employeeAddress1);
//        employeeAddressSet.add(employeeAddress2);
//        
//        employee.setEmployeeAddress(employeeAddressSet);
//        
//        employeeRepository.save(employee);
//        logger.info("Employee and Employee Address saved successfully!!");
		
	}

}
