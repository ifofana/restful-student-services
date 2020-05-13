/*
 * Filename: ContactRepository.java
 * Author: Jimmy Marr
 * Created: 23 Sep 2019
 * Purpose: Create a repository for Contact, child class of JPARepository
 */
package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}// end of ContactRepository interface