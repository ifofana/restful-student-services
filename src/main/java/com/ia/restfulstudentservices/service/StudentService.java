package com.ia.restfulstudentservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ia.restfulstudentservices.model.Student;

public interface StudentService {
	
	public Student saveStudent(Student s);
	
	public void deleteById(long id);
	
	public Student findById(long id);
	
	public Page<Student> findByCourseId(long courseId, Pageable pageable);
	
	public Optional<Student> findByIdAndCourseId(long id, long courseId);
	
	public List<Student> getAllStudents();
	
	public Student findByEmail(String email);
	
	public boolean existsById(long id);

}
