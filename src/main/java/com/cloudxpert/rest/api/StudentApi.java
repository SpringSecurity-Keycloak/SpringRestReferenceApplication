package com.cloudxpert.rest.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxpert.rest.error.StudentApiException;
import com.cloudxpert.rest.model.Student;
import com.cloudxpert.rest.service.StudentService;

/**
 * 
 * @author dennischacko
 *
 */
@RestController
@RequestMapping("/api/student/v1")
public class StudentApi {
    
	@Autowired
	private StudentService studentService;
    
    /**
     * 
     * @return
     */
	@GetMapping("/students")
	public List<Student> fetchAllStudents() {
        return studentService.fetchAllStudents();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping("/students/{studentId}")
	public Student retrieveByStudentId(@PathVariable Integer studentId) {
		Optional<Student> student = studentService.retrieveByStudentId(studentId);
		return student.orElseThrow(() -> new StudentApiException("Student Not Found () () - "+studentId,HttpStatus.NOT_FOUND));
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		Optional<Student> newStudent = studentService.addStudent(student);
		return newStudent.orElseThrow(() -> new StudentApiException("Unable to create student successfully",HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		Optional<Student> updatedStudent = studentService.updateStudent(student);
		return updatedStudent.orElseThrow(() -> new StudentApiException("Unable to update student",HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		this.retrieveByStudentId(studentId);// throws an exception if student is not found
		studentService.deleteStudent(studentId);
		return "Student successfully deleted";
	}
}
