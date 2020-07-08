package com.cloudxpert.rest.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxpert.rest.error.StudentApiException;
import com.cloudxpert.rest.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentApi {

	private List<Student> students = null;
    
	/**
	 * 
	 */
    @PostConstruct
    private void initializeData() {
    	Student student1 = new Student(1,"Pratibha","Patel");
    	Student student2 = new Student(2,"Hiten", "Shah");
        students = Arrays.asList(student1,student2);
    }
    
    /**
     * 
     * @return
     */
	@GetMapping("/students")
	public List<Student> fetchAllStudents() {
		
        return students;
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping("students/{studentId}")
	public Student retrieveByStudentId(@PathVariable Integer studentId) {
		Optional<Student> student = students.stream().filter(s -> s.getId().equals(studentId)).findFirst();
		return student.orElseThrow(() -> new StudentApiException("Student Not Found - "+studentId,HttpStatus.NOT_FOUND));
	}
	
}
