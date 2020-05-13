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

import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.repository.ParentGuardRepository;
import com.ia.restfulstudentservices.service.ParentGuardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParentGuardController {
	
	@Autowired
	ParentGuardRepository parentGuardRepo;
	
	@Autowired
	ParentGuardService parentGuardService;
	
	
	@GetMapping(path = "/api/guardians")
	public List<ParentGuard> getAllParentGuards( )
	{
		return parentGuardService.getAllParentGuards( );
	}
	
	@GetMapping(path = "/api/guardians/{id}")
	public ParentGuard getParentGuard(@PathVariable Long id)
	{
		return parentGuardService.findById(id);
	}
		
	@DeleteMapping(path = "/api/guardians/{id}")
	public ResponseEntity<Void> deleteParentGuard(@PathVariable Long id)
	{
		parentGuardService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(path = "/api/guardians")
	public ResponseEntity<Void> createParentGuard(@RequestBody ParentGuard parentGuard){
		
		ParentGuard parentGuardCreated = parentGuardService.saveParentGuard(parentGuard);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parentGuardCreated.getParentId()).toUri( );
		
		return ResponseEntity.created(uri).build( );
	}
	
	@PutMapping(path = "/api/guardians/{id}")
	public ResponseEntity<ParentGuard> updateParentGuard(@PathVariable long id, @RequestBody ParentGuard parentGuard) {
		
		ParentGuard parentGuardUpdated = parentGuardService.saveParentGuard(parentGuard);
		
		return new ResponseEntity<ParentGuard>(parentGuardUpdated, HttpStatus.OK);
	}
}
