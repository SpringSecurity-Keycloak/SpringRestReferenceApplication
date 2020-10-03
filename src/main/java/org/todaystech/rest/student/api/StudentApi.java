/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

package org.todaystech.rest.student.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.todaystech.rest.student.model.StudentResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T11:56:12.166Z[GMT]")
@Api(tags = {"StudentResource"}, description = "The Student API")

public interface StudentApi {

    @ApiOperation(value = "Delete a StudentResource", nickname = "deleteV1StudentResourceStudentResourceId", notes = "Delete a StudentResource", authorizations = {
        @Authorization(value = "OAuth2", scopes = { 
            @AuthorizationScope(scope = "StudentResourceService-Client1-Scope", description = "Client1&#x27;s scope")
            })    }, tags={ "StudentResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/api/v1/student/{StudentResourceId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStudent(@ApiParam(value = "",required=true) @PathVariable("StudentResourceId") Integer StudentResourceId
);


    @ApiOperation(value = "Get StudentResource By Id", nickname = "getApiV1StudentResourceStudentResourceId", notes = "Retrieve details for a single StudentResource", response = StudentResource.class, authorizations = {
        @Authorization(value = "OAuth2", scopes = { 
            @AuthorizationScope(scope = "StudentResourceService-Client1-Scope", description = "Client1&#x27;s scope")
            })    }, tags={ "StudentResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StudentResource.class),
        @ApiResponse(code = 201, message = "Created", response = StudentResource.class) })
    @RequestMapping(value = "/api/v1/student/{StudentResourceId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<StudentResource> retrieveByStudentId(@ApiParam(value = "",required=true) @PathVariable("StudentResourceId") Integer StudentResourceId
);


    @ApiOperation(value = "Retrieve All StudentResources", nickname = "getV1StudentResourceList", notes = "Retrieve a list of all the StudentResources", response = StudentResource.class, responseContainer = "List", authorizations = {
        @Authorization(value = "OAuth2", scopes = { 
            @AuthorizationScope(scope = "StudentResourceService-Client1-Scope", description = "Client1&#x27;s scope")
            })    }, tags={ "StudentResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StudentResource.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/api/v1/student/list",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<StudentResource>> getStudentList();


    @ApiOperation(value = "Update StudentResource", nickname = "postV1StudentResource", notes = "Add a new StudentResource", response = StudentResource.class, authorizations = {
        @Authorization(value = "OAuth2", scopes = { 
            @AuthorizationScope(scope = "StudentResourceService-Client1-Scope", description = "Client1&#x27;s scope")
            })    }, tags={ "StudentResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = StudentResource.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/api/v1/student",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<StudentResource> createStudent(@ApiParam(value = ""  )  @Valid @RequestBody StudentResource body
);


    @ApiOperation(value = "", nickname = "putApiV1StudentResource", notes = "Update details for a single StudentResource", authorizations = {
        @Authorization(value = "OAuth2", scopes = { 
            @AuthorizationScope(scope = "StudentResourceService-Client1-Scope", description = "Client1&#x27;s scope")
            })    }, tags={ "StudentResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/api/v1/student",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateStudent(@ApiParam(value = ""  )  @Valid @RequestBody StudentResource body
);

	    
}
