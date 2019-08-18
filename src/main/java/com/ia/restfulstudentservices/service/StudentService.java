package com.ia.restfulstudentservices.service;

import java.util.List;

import com.ia.restfulstudentservices.model.Student;

public interface StudentService {
	
	public Student saveStudent(Student s);
	
	public void deleteById(long id);
	
	public Student findById(long id);
	
	public List<Student> getAllStudents();
	
	public Student findByEmail(String email);

}
