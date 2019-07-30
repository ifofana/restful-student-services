package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
	

}
