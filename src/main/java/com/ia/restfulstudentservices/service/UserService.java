package com.ia.restfulstudentservices.service;

import java.util.List;

import com.ia.restfulstudentservices.model.User;

public interface UserService {
	User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();

}
