package org.todaystech.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todaystech.rest.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
