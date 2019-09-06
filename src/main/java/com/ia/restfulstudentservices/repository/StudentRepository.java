package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ia.restfulstudentservices.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
