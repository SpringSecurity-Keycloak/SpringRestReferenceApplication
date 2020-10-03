package org.todaystech.rest.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todaystech.rest.student.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
