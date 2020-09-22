package com.cloudxpert.rest.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cloudxpert.rest.entity.StudentEntity;
import com.cloudxpert.rest.error.StudentApiException;
import com.cloudxpert.rest.model.StudentResource;
import com.cloudxpert.rest.service.StudentService;

/**
 * 
 * @author dennischacko
 *
 */
@RestController
public class StudentController implements StudentApi{
    
	@Autowired
	private StudentService studentService;
	
	@Autowired
    private BuildProperties buildProperties;
    
	public BuildProperties version() {
		return this.buildProperties;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RolesAllowed("user")
	public ResponseEntity<List<StudentResource>> getStudentList() {
		List<StudentEntity> students = studentService.fetchAllStudents();
		List<StudentResource> listOfStudents = students
												.stream()
		        								.map(student -> toStudentResource(student))
		        								.collect(Collectors.toList());
		
		return new ResponseEntity<List<StudentResource>>(listOfStudents,HttpStatus.OK);
	}
	
	@Deprecated
	public List<StudentEntity> fetchAllStudents() {
        return studentService.fetchAllStudents();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public StudentEntity retrieveByStudentId( Integer studentId) {
		Optional<StudentEntity> student = studentService.retrieveByStudentId(studentId);
		return student.orElseThrow(() -> new StudentApiException("Student Not Found for student id - "+studentId,HttpStatus.NOT_FOUND));
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@RolesAllowed("admin")
	public ResponseEntity<StudentResource> createStudent(StudentResource student) {
		
		Optional<StudentEntity> newStudent = studentService.addStudent(toStudentEntity(student));
		ResponseEntity<StudentResource> studentResource = toResponseEntity(newStudent,"Unable to create student successfully",HttpStatus.INTERNAL_SERVER_ERROR);;
		
		return studentResource;
	}

	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@RolesAllowed("admin")
	public ResponseEntity<Void> updateStudent(StudentResource student) {
		Optional<StudentEntity> updatedStudent = studentService.updateStudent(toStudentEntity(student));
		return updatedStudent.map(s -> new ResponseEntity<Void>(HttpStatus.OK))
					  		 .orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
					  
					 
		
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@RolesAllowed("admin")
	public ResponseEntity<Void> deleteStudent( Integer studentId) {
		this.retrieveByStudentId(studentId);// throws an exception if student is not found
		studentService.deleteStudent(studentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * Convert StudentEntity to StudentResource
	 * @param studentEntity
	 * @return
	 */
	private static StudentResource toStudentResource(StudentEntity studentEntity) {
		StudentResource studentResource = new StudentResource();
		studentResource.setFirstName(studentEntity.getFirstName());
		studentResource.setLastName(studentEntity.getLastName());
		studentResource.setId(studentEntity.getId());
		return studentResource;
	}
	
	/**
	 * Convert StudentResource to Student Entity
	 * @param studentResource
	 * @return
	 */
	private StudentEntity toStudentEntity(StudentResource studentResource) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstName(studentResource.getFirstName());
		studentEntity.setLastName(studentResource.getLastName());
		studentEntity.setId(studentResource.getId());
		return studentEntity;
	}
	
	/**
	 * 
	 * @param student
	 * @param message
	 * @param httpStatus
	 * @return
	 */
	private ResponseEntity<StudentResource> toResponseEntity(Optional<StudentEntity> student,String message, HttpStatus httpStatus) {
		ResponseEntity<StudentResource> studentResource = student
				.map(StudentController::toStudentResource)
				.map(resource -> new ResponseEntity<StudentResource>(resource,HttpStatus.OK))
				.orElseThrow (() -> new StudentApiException("Unable to create student successfully",HttpStatus.INTERNAL_SERVER_ERROR));
		return studentResource;
	}

}
