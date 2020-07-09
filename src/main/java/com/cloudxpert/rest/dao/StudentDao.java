package com.cloudxpert.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudxpert.rest.model.Student;
import com.cloudxpert.rest.service.StudentService;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public Optional<Student> retrieveByStudentId(Integer studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		return student;
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<Student> saveStudent(Student student) {
		Student newStudent = studentRepository.save(student);
		return Optional.ofNullable(newStudent);
	}

	/**
	 * 
	 * @param studentId
	 */
	public void deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);;
	}
}
