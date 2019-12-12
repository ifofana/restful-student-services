/*
 * Filename: ContactServiceImpl
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: implement ContactService interface.
 */

package com.ia.restfulstudentservices.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.Contact;
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



