package org.todaystech.rest.student.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.todaystech.rest.student.entity.StudentEntity;
import org.todaystech.rest.student.model.StudentResource;
import org.todaystech.rest.student.service.StudentService;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author dennischacko
 *
 */

public class StudentControllerTestCase {

  @Mock
  private StudentService studentService;

  @InjectMocks
  private StudentController studentController;

  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getStudentList() {
    List<StudentEntity> expectedResult = new ArrayList<>();
    Collections.addAll(expectedResult, this.createTestResource());
    when(studentService.fetchAllStudents()).thenReturn(expectedResult);

    ResponseEntity<List<StudentResource>> actualResult = studentController.getStudentList();
    Assert.assertEquals(expectedResult.get(0).getFirstName(), actualResult.getBody().get(0).getFirstName());
  }

  @Test
  public void retrieveByStudentId() {

    StudentEntity expectedResult = this.createTestResource();
    when(studentService.retrieveByStudentId(123)).thenReturn(Optional.of(expectedResult));
    ResponseEntity<StudentResource> actualResult = studentController.retrieveByStudentId(123);

    Assert.assertEquals(expectedResult.getFirstName(), actualResult.getBody().getFirstName());
  }

  @Test
  public void createStudent() {
    StudentEntity expectedResult = this.createTestResource();
    when(studentService.addStudent(expectedResult)).thenReturn(Optional.of(expectedResult));

    ResponseEntity<StudentResource> actualResult = studentController.createStudent(this.createStudentResource());

    Assert.assertEquals(expectedResult.getFirstName(), actualResult.getBody().getFirstName());
  }

  @Test
  public void updateStudent() {
    StudentEntity expectedResult = this.createTestResource();
    when(studentService.updateStudent(expectedResult)).thenReturn(Optional.of(expectedResult));

    ResponseEntity<Void> actualResult = studentController.updateStudent(this.createStudentResource());
    Assert.assertEquals(HttpStatus.OK, actualResult.getStatusCode());
  }

  @Test
  public void deleteStudent() {
    StudentEntity expectedResult = this.createTestResource();
    when(studentService.retrieveByStudentId(123)).thenReturn(Optional.of(expectedResult));

    ResponseEntity<Void> actualResult = studentController.deleteStudent(123);
    Assert.assertEquals(HttpStatus.OK, actualResult.getStatusCode());
  }

  /**
   * Create test subject
   * 
   * @return
   */
  private StudentEntity createTestResource() {
    StudentEntity student = new StudentEntity();
    student.setFirstName("John");
    student.setLastName("Doe");
    student.setId(1);
    return student;
  }

  /**
   * Create test subject
   * 
   * @return
   */
  private StudentResource createStudentResource() {
    StudentResource student = new StudentResource();
    student.setFirstName("John");
    student.setLastName("Doe");
    student.setId(1);
    return student;
  }

}
