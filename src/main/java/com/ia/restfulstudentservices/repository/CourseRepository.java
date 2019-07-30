package com.ia.restfulstudentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ia.restfulstudentservices.model.Course;

@Repository
//public interface CourseRepository extends CrudRepository<Course, Long> {
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByName(String name);
		
}
