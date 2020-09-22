/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

package com.cloudxpert.rest.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudxpert.rest.model.StudentResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T11:56:12.166Z[GMT]")
@Api(value = "v1", description = "The StudentService API")

public interface StudentApi {

	@ApiOperation(value = "Delete a student", nickname = "deleteV1StudentStudentId", notes = "Delete a student", 
			authorizations = {
					@Authorization(value = "OAuth2", 
							scopes = {
							@AuthorizationScope(scope = "StudentService-Client1-Scope", description = "Client1&#x27;s scope") 
							}) 
			}, 
			tags = {
					"Student", 
			})
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") 
			})
	@RequestMapping(value = "/v1/student/{studentId}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteStudent(@ApiParam(value = "", required = true) @PathVariable("studentId") Integer studentId);

	@ApiOperation(value = "Retrieve All Students", nickname = "getV1StudentList", notes = "Retrieve a list of all the students", response = StudentResource.class, responseContainer = "List", authorizations = {
			@Authorization(value = "OAuth2", scopes = {
					@AuthorizationScope(scope = "StudentService-Client1-Scope", description = "Client1&#x27;s scope") }) }, tags = {
							"Student", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = StudentResource.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/v1/student/list", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<StudentResource>> getStudentList();

	@ApiOperation(value = "", nickname = "postV1Student", notes = "Add a new Student", response = StudentResource.class, authorizations = {
			@Authorization(value = "OAuth2", scopes = {
					@AuthorizationScope(scope = "StudentService-Client1-Scope", description = "Client1&#x27;s scope") }) }, tags = {
							"Student", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = StudentResource.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/v1/student", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<StudentResource> createStudent(@ApiParam(value = "") @Valid @RequestBody StudentResource body);

	@ApiOperation(value = "Update student details", nickname = "putV1StudentStudentId", notes = "Update a student details", authorizations = {
			@Authorization(value = "OAuth2", scopes = {
					@AuthorizationScope(scope = "StudentService-Client1-Scope", description = "Client1&#x27;s scope") }) }, tags = {
							"Student", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StudentResource.class) })
	@RequestMapping(value = "/v1/student/{studentId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateStudent(@ApiParam(value = "") @Valid @RequestBody StudentResource body);
}
