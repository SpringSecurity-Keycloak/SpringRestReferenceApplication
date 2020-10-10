package org.todaystech.rest.student.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.todaystech.rest.student.entity.StudentEntity;
import org.todaystech.rest.student.error.StudentApiException;
import org.todaystech.rest.student.model.StudentResource;
import org.todaystech.rest.student.service.StudentService;

/**
 * 
 * @author dennischacko
 *
 */
@RestController
@CrossOrigin
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
	@Override
	@PreAuthorize("hasAnyAuthority('SCOPE_StudentService-write','SCOPE_StudentService-read')")
	public ResponseEntity<List<StudentResource>> getStudentList() {
		List<StudentEntity> students = studentService.fetchAllStudents();
		List<StudentResource> listOfStudents = students
												.stream()
		        								.map(student -> toStudentResource(student))
		        								.collect(Collectors.toList());
		
		return new ResponseEntity<List<StudentResource>>(listOfStudents,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('SCOPE_StudentService-write','SCOPE_StudentService-read')")
	public  ResponseEntity<StudentResource> retrieveByStudentId( Integer studentId) {
		Optional<StudentEntity> student = studentService.retrieveByStudentId(studentId);
		return  toResponseEntity(student, "Student not found in system", HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@Override
	@PreAuthorize("hasAnyAuthority('SCOPE_StudentService-write')")
	public ResponseEntity<StudentResource> createStudent(StudentResource student) {
		
		Optional<StudentEntity> newStudent = studentService.addStudent(toStudentEntity(student));
		ResponseEntity<StudentResource> studentResource = toResponseEntity(newStudent,"Unable to create student successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		
		return studentResource;
	}

	
	/**
	 * 
	 * @param student
	 * @return
	 */
	@Override
	@PreAuthorize("hasAnyAuthority('SCOPE_StudentService-write')")
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
	@Override
	@PreAuthorize("hasAnyAuthority('SCOPE_StudentService-write')")
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
	 * @param student return a Student wrapped in a ResponseEntity or
	 * @param errorMessage return an error message
	 * @param errorHttpStatus with an error Http status
	 * @return
	 */
	private ResponseEntity<StudentResource> toResponseEntity(Optional<StudentEntity> student,String errorMessage, HttpStatus errorHttpStatus) {
		ResponseEntity<StudentResource> studentResource = student
				.map(StudentController::toStudentResource)
				.map(resource -> new ResponseEntity<StudentResource>(resource,HttpStatus.OK))
				.orElseThrow (() -> new StudentApiException(errorMessage,errorHttpStatus));
		System.out.println("Trigger Travis Build");
		return studentResource;
	}

}
