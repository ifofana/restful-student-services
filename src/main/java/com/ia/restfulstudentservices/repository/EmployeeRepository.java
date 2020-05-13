package com.ia.restfulstudentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ia.restfulstudentservices.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

}