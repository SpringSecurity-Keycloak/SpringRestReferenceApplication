package org.todaystech.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todaystech.rest.dao.StudentDao;
import org.todaystech.rest.entity.StudentEntity;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<StudentEntity> fetchAllStudents() {
        return studentDao.fetchAllStudents();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Transactional
	public Optional<StudentEntity> retrieveByStudentId(Integer studentId) {
		Optional<StudentEntity> student = studentDao.retrieveByStudentId(studentId);
		return student;
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<StudentEntity> addStudent(StudentEntity student) {
		return studentDao.saveStudent(student);
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public Optional<StudentEntity> updateStudent(StudentEntity student) {
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
