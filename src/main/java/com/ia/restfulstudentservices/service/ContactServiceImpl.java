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
//		logger.debug("debug message");
//		logger.info("This is an info message saveContact");
//		logger.warn("Warning for this application saveContact");
//		logger.error("Seems error in the application saveContact");
		logger.info("<<Contact:>>" + c.toString());
		
		logger.info("<<LOG>>1");
		logger.info("<<LOG>>2");
//        Student student1 = new Student();		
//        student1.setFirstName("Imran");
//        student1.setMiddlename("");
//        student1.setLastName("Hossein");
//        Calendar calendar1 = new GregorianCalendar(2010,01,07);
//        student1.setDob(calendar1.getTime());
//        student1.setAge(9);
//        student1.setGender("Male");
//        student1.setAllerges("Smoke/Jelly");
//        student1.setClassDay("Saturday");
//        student1.setClassSelection("intermediate");
//        student1.setCreatedBy("SystemTest");
//        student1.setCreatedOn(new Date());
//        student1.setContact(c);
//        
//        Student student2 = new Student();
//		student2.setFirstName("Mariam");
//		student2.setMiddlename("I.");
//		student2.setLastName("Fofana");
//		Calendar calendar2 = new GregorianCalendar(2012,11,28);
//		student2.setDob(calendar2.getTime());
//		student2.setAge(6);
//		student2.setGender("Female");
//		student2.setAllerges("N/A");
//		student2.setClassDay("Saturday");
//		student2.setClassSelection("foundtion");
//		student2.setCreatedBy("SystemTest");
//		student2.setCreatedOn(new Date());
//		student2.setContact(c);
//
//        Set<Student> studentSet = new HashSet<Student>();
//        studentSet.add(student1);
//        studentSet.add(student2);
//
//        ParentGuard pg1 = new ParentGuard();
//        pg1.setPgName("Habi Fall");
//        pg1.setPgAddressOne("7245 Grey Eagle Court");
//        pg1.setPgCity("Germantown");
//        pg1.setPgState("Maryland");
//        pg1.setPgZipCode("20874");
//        pg1.setPgPhoneNumber("321.567.8989");
//        pg1.setPgEmail("Habi.Fall@gmail.com");
//        pg1.setPgAltEmail("firsthabi@hotmail.com");
//        pg1.setPgRelationshipToStudent("Step-Mother");		
//        pg1.setStudent(student1);
//        
//        ParentGuard pg2 = new ParentGuard();
//        pg2.setPgName("Ndeye Awa Fall");
//        pg2.setPgAddressOne("7245 Grey Eagle Court");
//        pg2.setPgCity("Germantown");
//        pg2.setPgState("Maryland");
//        pg2.setPgZipCode("20874");
//        pg2.setPgPhoneNumber("321.567.8989");
//        pg2.setPgEmail("Ndeye.Fall@gmail.com");
//        pg2.setPgAltEmail("firstndeye@hotmail.com");
//        pg2.setPgRelationshipToStudent("Step-Sister");		
//        pg2.setStudent(student1);
//
//        Set<ParentGuard> pgSet = new HashSet<ParentGuard>();
//        pgSet.add(pg1);
//        pgSet.add(pg2);
//
//        student1.setParentGuards(pgSet);		
//        c.setStudents(studentSet);
        logger.info("<<LOG>>3");
        
//        Set<Student> sSet = c.getStudents(); 
//        logger.info("sSet.size="+sSet.size());
//        if(sSet != null && sSet.size() > 0) {
//        	for (Student s : sSet) {
//    			if(s != null)
//    				logger.info("<<s>>:" + s.toString());
//    			Set<ParentGuard> pSet = s.getParentGuards();
//    				if(pSet != null && pSet.size() > 0) {
//    					for (ParentGuard p : pSet) {
//							if(p != null)
//								logger.info("<<p>>:"+p.toString());
//						}
//    				}
//    		}
//		}
        
		return contactRepo.save(c);
	}

	@Override
	public Contact findById(long id) {		
		return contactRepo.findById(id).get( );
	}

	@Override
	public List<Contact> getAllContacts( ) {
//		logger.debug("debug message");
//		logger.info("This is an info message getAllContacts");
//		logger.warn("Warning for this application getAllContacts");
//		logger.error("Seems error in the application getAllContacts");
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



