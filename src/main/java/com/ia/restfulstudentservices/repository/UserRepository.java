package com.ia.restfulstudentservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ia.restfulstudentservices.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
