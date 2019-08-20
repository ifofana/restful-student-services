package com.ia.restfulstudentservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public void deleteById(long id) {
		
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student saveStudent(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public Student findById(long id) {		
		return studentRepo.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student findByEmail(String email) {
		return studentRepo.findByEmail(email).orElse(null);
	}

	@Override
	public Page<Student> findByCourseId(long courseId, Pageable pageable) {
		// TODO Auto-generated method stub
		return studentRepo.findByCourseId(courseId, pageable);
	}

	@Override
	public Optional<Student> findByIdAndCourseId(long id, long courseId) {
		// TODO Auto-generated method stub
		return studentRepo.findByIdAndCourseId(id, courseId);
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return studentRepo.existsById(id);
	}

}
