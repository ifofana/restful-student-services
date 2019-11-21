/*
 * Filename: ContactServiceImpl
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: implement ContactService interface.
 */

package com.ia.restfulstudentservices.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.Contact;
import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	ContactRepository contactRepo;

	@Override
	public void deleteById(long id) {
		
		contactRepo.deleteById(id);	
	}

	@Override
	public Contact saveContact(Contact c) {
		logger.debug("debug message");
		logger.info("This is an info message saveContact");
		logger.warn("Warning for this application saveContact");
		logger.error("Seems error in the application saveContact");
        
        Student student1 = new Student();		
        student1.setFirstName("Imran");
        //student1.setMiddlename("");
        student1.setLastName("Hossein");
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar1 = new GregorianCalendar(2010,01,07);
        student1.setDob(calendar1.getTime());
        student1.setAge(9);
        student1.setGender("Male");
        student1.setAllerges("Smoke/Jelly");
        student1.setClassDay("Saturday");
        student1.setClassSelection("intermediate");
        student1.setCreatedBy("SystemTest");
        student1.setCreatedOn(new Date());
        student1.setContact(c);

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);

        ParentGuard pg = new ParentGuard();
        pg.setPgName("Habi Fall");
        pg.setPgAddressOne("7245 Grey Eagle Court");
        pg.setPgCity("Germantown");
        pg.setPgState("Maryland");
        pg.setPgZipCode("20874");
        pg.setPgPhoneNumber("321.567.8989");
        pg.setPgEmail("Habi.Fall@gmail.com");
        pg.setPgAltEmail("firsthabi@hotmail.com");
        pg.setPgRelationshipToStudent("Step-Mother");		
        pg.setStudent(student1);

        Set<ParentGuard> pgSet = new HashSet<ParentGuard>();
        pgSet.add(pg);

        student1.setParentGuards(pgSet);		
        c.setStudents(studentSet);

        logger.info("Contact and Contact Student saved successfully!!");
		return contactRepo.save(c);
	}

	@Override
	public Contact findById(long id) {		
		return contactRepo.findById(id).get( );
	}

	@Override
	public List<Contact> getAllContacts( ) {
		logger.debug("debug message");
		logger.info("This is an info message getAllContacts");
		logger.warn("Warning for this application getAllContacts");
		logger.error("Seems error in the application getAllContacts");
		return contactRepo.findAll( );
	}	

	@Override
	public boolean existsById(long id) {
		return contactRepo.existsById(id);
	}

	@Override
	public Contact findById(Long id) {
		return contactRepo.findById(id).get();
	}

}// end of ContactServiceImpl class



