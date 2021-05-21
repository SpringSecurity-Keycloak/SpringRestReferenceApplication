package org.todaystech.rest.student.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.todaystech.rest.student.dao.StudentDao;
import org.todaystech.rest.student.entity.StudentEntity;
import org.junit.Assert;

public class StudentServiceTestCase {

  @Mock
  private StudentDao studentDao;

  @InjectMocks
  private StudentService studentService;

  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void fetchAllStudents() {
    List<StudentEntity> expectedResult = new ArrayList<>();
    Collections.addAll(expectedResult, new StudentEntity());
    when(studentDao.fetchAllStudents()).thenReturn(expectedResult);

    List<StudentEntity> actualResult = studentService.fetchAllStudents();

    Assert.assertEquals(actualResult.size(), expectedResult.size());
  }

  @Test
  public void addStudent() {
    StudentEntity expectedResult = this.createTestStudentEntity();
    when(studentDao.saveStudent(expectedResult)).thenReturn(Optional.of(expectedResult));

    Optional<StudentEntity> actualResult = studentService.addStudent(expectedResult);
    Assert.assertEquals(actualResult.get().getFirstName(), expectedResult.getFirstName());
  }

  @Test
  public void updateStudent() {
    StudentEntity expectedResult = this.createTestStudentEntity();
    when(studentDao.saveStudent(expectedResult)).thenReturn(Optional.of(expectedResult));

    Optional<StudentEntity> actualResult = studentService.updateStudent(expectedResult);
    Assert.assertEquals(actualResult.get().getFirstName(), expectedResult.getFirstName());
  }

  @Test
  public void deleteStudent() {
    StudentEntity expectedResult = this.createTestStudentEntity();
    try {
      studentService.deleteStudent(expectedResult.getId());
    } catch (Exception ex) {
      Assert.fail();
    }

  }

  @Test
  public void retrieveByStudentId() {
    StudentEntity expectedResult = this.createTestStudentEntity();
    when(studentDao.retrieveByStudentId((123))).thenReturn(Optional.of(expectedResult));

    Optional<StudentEntity> actualResult = studentService.retrieveByStudentId(123);
    Assert.assertEquals(expectedResult.getFirstName(), actualResult.get().getFirstName());
    Assert.assertEquals(expectedResult, actualResult.get());
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
