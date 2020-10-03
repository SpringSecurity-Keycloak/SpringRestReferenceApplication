package org.todaystech.rest.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.todaystech.rest.student.entity.StudentEntity;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<StudentEntity> fetchAllStudents() {
        return studentRepository.findAll();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public Optional<StudentEntity> retrieveByStudentId(Integer studentId) {
		Optional<StudentEntity> student = studentRepository.findById(studentId);
		return student;
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<StudentEntity> saveStudent(StudentEntity student) {
		StudentEntity newStudent = studentRepository.save(student);
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
