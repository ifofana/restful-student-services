/*
 * Filename: ContactService.java
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: Create an interface for ContactService
 */

package com.ia.restfulstudentservices.service;

// Import List class from java.util package
import java.util.List;

// import Contact class from com.ia.restfulstudentservices.model package
import com.ia.restfulstudentservices.model.Contact;

public interface ContactService {
	
	public Contact saveContact(Contact c);
	
	public void deleteById(long id);
	
	public boolean existsById(long id);

	public List<Contact> getAllContacts();

	public Contact findById(Long id);

	Contact findById(long id);

}// end of ContactService Interface class
