package com.ia.restfulstudentservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByCourseId(long courseId);	
	
	Optional<Student> findByEmail(String email);

}
