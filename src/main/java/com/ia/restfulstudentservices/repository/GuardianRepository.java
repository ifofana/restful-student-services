package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.ParentGuard;

@Repository
public interface GuardianRepository extends JpaRepository<ParentGuard, Long> {

}
