package org.todaystech.rest.student.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.todaystech.rest.student.entity.StudentEntity;

public class StudentDaoTestCase {

  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentDao studentDao;

  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void fetchAllStudents() {

    List<StudentEntity> expectedResult = new ArrayList<>();
    Collections.addAll(expectedResult, this.createTestStudentEntity());

    when(studentRepository.findAll()).thenReturn(expectedResult);
    List<StudentEntity> actualResult = studentDao.fetchAllStudents();

    Assert.assertEquals(expectedResult.get(0).getFirstName(), actualResult.get(0).getFirstName());
  }

  @Test
  public void retrieveByStudentId() {

    StudentEntity expectedResult = this.createTestStudentEntity();
    when(studentRepository.findById(123)).thenReturn(Optional.of(expectedResult));

    Optional<StudentEntity> actualResult = studentDao.retrieveByStudentId(123);
    Assert.assertEquals(expectedResult, actualResult.get());

  }

  @Test
  public void saveStudent() {
    StudentEntity expectedResult = this.createTestStudentEntity();
    when(studentRepository.save(expectedResult)).thenReturn(expectedResult);

    Optional<StudentEntity> actualResult = studentDao.saveStudent(expectedResult);
    Assert.assertEquals(expectedResult, actualResult.get());
  }

  @Test
  public void deleteStudent() {
    try {
      studentDao.deleteStudent(123);
    } catch (Exception ex) {
      Assert.fail("Delete Student testcase failed!");
    }
  }

  /**
   * Create a test subject
   * 
   * @return
   */
  private StudentEntity createTestStudentEntity() {
    StudentEntity testEntity = new StudentEntity();
    testEntity.setFirstName("John");
    testEntity.setLastName("Doe");
    testEntity.setId(1);
    return testEntity;
  }

}
