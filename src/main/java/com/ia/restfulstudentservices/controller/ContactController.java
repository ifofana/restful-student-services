/*
 * Filename: ContactController
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: Controller for Contact
 */

package com.ia.restfulstudentservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ia.restfulstudentservices.model.Contact;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.service.ContactService;
import com.ia.restfulstudentservices.service.StudentService;

@CrossOrigin(origins = 
"http://angular-project-isg.s3-website-us-east-1.amazonaws.com:4200")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ContactService contactService;
	
	
	@GetMapping(path = "/api/contacts")
	public List<Contact> getAllContacts( )
	{
		return contactService.getAllContacts( );
	}
	
	@GetMapping(path = "/api/contacts/{id}")
	public Contact getContact(@PathVariable Long id)
	{
		return contactService.findById(id);
	}
		
	@DeleteMapping(path = "/api/contacts/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id)
	{
		contactService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(path = "/api/contacts")
	public ResponseEntity<Void> createContact(@RequestBody Contact contact){
		
		logger.info("Initiating Contact and Contact Student save...");
//		logger.warn("createContact ====> this is a warn message");
//		logger.error("createContact ===> this is a error message");
		logger.info("contact ID=" + contact.getContactId());
		logger.info(contact.toString());
		
		Contact contactCreated = contactService.saveContact(contact);
		
		Set<Student> cStudents = contactCreated.getStudents();
		logger.info("cStudents.size="+cStudents.size());
        if(cStudents != null && cStudents.size() > 0) {
        	for (Student s : cStudents) {
    			if(s != null) {
    				logger.info("<<s>>:" + s.toString());
    				s.setContactId(contactCreated.getContactId());
    			}
    		}
		}
        
        Contact contactUpdated = contactService.saveContact(contactCreated);
		
		logger.info("Contact and Contact Student saved successfully!!");
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contactUpdated.getContactId()).toUri( );
		
		return ResponseEntity.created(uri).build( );
	}
	
	@PutMapping(path = "/api/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact) {
		
		Contact contactUpdated = contactService.saveContact(contact);
		
		return new ResponseEntity<Contact>(contactUpdated, HttpStatus.OK);
	}
}
