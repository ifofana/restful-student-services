package com.ia.restfulstudentservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.Course;
import com.ia.restfulstudentservices.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Course saveCourse(Course c) {
		return courseRepo.save(c);
	}

	@Override
	public void deleteById(long id) {
		
		courseRepo.deleteById(id);
		
	}

	@Override
	public Course findById(long id) {
		return courseRepo.findById(id).get();
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public List<Course> findByName(String name) {
		return courseRepo.findByName(name);
	}

}
