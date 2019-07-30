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

import com.ia.restfulstudentservices.model.User;
import com.ia.restfulstudentservices.service.AccountService;

/*
 * 
 * SELECT u.ID,u.USERNAME ,u.PASSWORD ,u.ENABLED ,a.AUTHORITY , a.USER_ID 
	FROM USERS u
	JOIN AUTHORITIES a
	ON u.ID = a.USER_ID 
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(path = "/training/users")
	public List<User> getAllUsers() {
		return accountService.getAllUsers();
	}

	@GetMapping(path = "/training/users/{id}")
	public User getUser(@PathVariable Long id) {
		return accountService.findById(id);
	}

	@DeleteMapping(path = "/training/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		accountService.deleteById(id);

		return ResponseEntity.noContent().build();

	}

	@PostMapping(path = "/training/users")
	public ResponseEntity<Void> createUser(@RequestBody User user) {

		User userCreated = accountService.registerNewUserAccount(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/training/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {

		User userUpdated = accountService.registerNewUserAccount(user);

		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}

}
