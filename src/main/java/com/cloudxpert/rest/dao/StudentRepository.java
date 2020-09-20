package com.cloudxpert.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudxpert.rest.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
