package com.cloudxpert.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudxpert.rest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
