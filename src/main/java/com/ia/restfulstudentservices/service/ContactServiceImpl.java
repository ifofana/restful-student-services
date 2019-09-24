/*
 * Filename: ContactServiceImpl
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: implement ContactService interface.
 */

package com.ia.restfulstudentservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.Contact;
import com.ia.restfulstudentservices.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository contactRepo;

	@Override
	public void deleteById(long id) {
		
		contactRepo.deleteById(id);	
	}

	@Override
	public Contact saveContact(Contact c) {
		return contactRepo.save(c);
	}

	@Override
	public Contact findById(long id) {		
		return contactRepo.findById(id).get( );
	}

	@Override
	public List<Contact> getAllContacts( ) {
		return contactRepo.findAll( );
	}	

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return contactRepo.existsById(id);
	}

	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}// end of ContactServiceImpl class



