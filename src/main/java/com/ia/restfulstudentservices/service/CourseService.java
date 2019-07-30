package com.ia.restfulstudentservices.service;

import java.util.List;

import com.ia.restfulstudentservices.model.Course;

public interface CourseService {
	
	public Course saveCourse(Course c);
	
	public void deleteById(long id);
	
	public Course findById(long id);
	
	public List<Course> getAllCourses();
	
	public List<Course> findByName(String name);

}
