package com.cloudxpert.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxpert.rest.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentApi {

	@GetMapping("/students")
	public Student[] fetchAllStudents() {
		Student student1 = new Student(1,"Pratibha","Patel");
		Student student2 = new Student(2,"Hiten", "Shah");
        Student[] students = new Student[]  {student1, student2};
        return students;
	}
}
