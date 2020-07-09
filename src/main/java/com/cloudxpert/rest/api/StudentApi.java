package com.cloudxpert.rest.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxpert.rest.error.StudentApiException;
import com.cloudxpert.rest.model.Student;
import com.cloudxpert.rest.model.StudentRepository;

@RestController
@RequestMapping("/api/student/v1")
public class StudentApi {
    
	@Autowired
	private StudentRepository repository;
    
    /**
     * 
     * @return
     */
	@GetMapping("/students")
	public List<Student> fetchAllStudents() {
        return repository.findAll();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping("students/{studentId}")
	public Student retrieveByStudentId(@PathVariable Integer studentId) {
		Optional<Student> student = repository.findById(studentId);
		return student.orElseThrow(() -> new StudentApiException("Student Not Found - "+studentId,HttpStatus.NOT_FOUND));
	}
	
}
