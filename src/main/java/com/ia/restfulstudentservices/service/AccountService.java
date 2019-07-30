package com.ia.restfulstudentservices.service;

import java.util.List;

import com.ia.restfulstudentservices.model.User;

public interface AccountService {
	
	public User registerNewUserAccount(User user);
	
	public void deleteById(long id);
	
	public User findById(long id);
	
	public List<User> getAllUsers();
	
	public User findByUsername(String username);

}
