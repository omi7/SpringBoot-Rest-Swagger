package com.esolutions.employeemanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Employee {
	@ApiModelProperty(notes = "Name of the Employee",name="firstName",required=true,value="test name")
	@JsonProperty("firstName")
	private String firstName;
	@ApiModelProperty(notes = "Last Name of the Employee",name="lastName",required=true,value="test lastname")
	@JsonProperty("lastName")
	private String lastName;
	@ApiModelProperty(notes = "Id of the Employee",name="id",required=true,value="test id")
	@JsonProperty("id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [firstName= " + firstName + ", lastName= "+ lastName+", id=" + id  + "]";
	}

}
