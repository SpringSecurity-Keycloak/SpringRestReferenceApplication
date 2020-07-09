package com.cloudxpert.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudxpert.rest.dao.StudentDao;
import com.cloudxpert.rest.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Student> fetchAllStudents() {
        return studentDao.fetchAllStudents();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Transactional
	public Optional<Student> retrieveByStudentId(Integer studentId) {
		Optional<Student> student = studentDao.retrieveByStudentId(studentId);
		return student;
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<Student> addStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<Student> updateStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	/**
	 * 
	 * @param studentId
	 */
	public void deleteStudent(Integer studentId) {
		 studentDao.deleteStudent(studentId);
		
	}
	
}
