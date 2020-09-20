package com.cloudxpert.rest.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * StudentResource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T11:56:12.166Z[GMT]")


public class StudentResource {


	  @JsonProperty("id")
	  private Integer id = null;

	  @JsonProperty("firstName")
	  private String firstName = null;

	  @JsonProperty("lastName")
	  private String lastName = null;

	  public StudentResource id(Integer id) {
	    this.id = id;
	    return this;
	  }

	  /**
	   * Get id
	   * @return id
	  **/
	  @ApiModelProperty(value = "")
	  
	    public Integer getId() {
	    return id;
	  }

	  public void setId(Integer id) {
	    this.id = id;
	  }

	  public StudentResource firstName(String firstName) {
	    this.firstName = firstName;
	    return this;
	  }

	  /**
	   * Get firstName
	   * @return firstName
	  **/
	  @ApiModelProperty(value = "")
	  
	    public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public StudentResource lastName(String lastName) {
	    this.lastName = lastName;
	    return this;
	  }

	  /**
	   * Get lastName
	   * @return lastName
	  **/
	  @ApiModelProperty(value = "")
	  
	    public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    StudentResource student = (StudentResource) o;
	    return Objects.equals(this.id, student.id) &&
	        Objects.equals(this.firstName, student.firstName) &&
	        Objects.equals(this.lastName, student.lastName);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, firstName, lastName);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Student {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
