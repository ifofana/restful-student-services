/*
 * Filename: ContactController
 * Author: Jimmy Marr
 * Date: 23 Sept 2019
 * Purpose: Controller for Contact
 */

package com.ia.restfulstudentservices.controller;

import java.net.URI;
import java.util.List;

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
import com.ia.restfulstudentservices.repository.ContactRepository;
import com.ia.restfulstudentservices.service.ContactService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {
	
	@Autowired
	ContactRepository contactRepo;
	
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
		
		Contact contactCreated = contactService.saveContact(contact);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contactCreated.getId( )).toUri( );
		
		return ResponseEntity.created(uri).build( );
	}
	
	@PutMapping(path = "/api/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact) {
		
		Contact contactUpdated = contactService.saveContact(contact);
		
		return new ResponseEntity<Contact>(contactUpdated, HttpStatus.OK);
	}
}
