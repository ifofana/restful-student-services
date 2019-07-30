package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.User;

@Repository
public interface AccoutRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
