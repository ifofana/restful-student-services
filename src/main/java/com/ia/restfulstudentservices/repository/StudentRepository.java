package com.ia.restfulstudentservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ia.restfulstudentservices.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByCourseId(long courseId);
	
	Page<Student> findByCourseId(long courseId, Pageable pageable);	
	
	Optional<Student> findByIdAndCourseId(long id, long courseId);
	
	Optional<Student> findByEmail(String email);

}
