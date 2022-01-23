package com.esolutions.employeemanagement.controller;

import java.util.List;

import com.esolutions.employeemanagement.dao.EmployeeRepository;
import com.esolutions.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "EmployeeManagementRestController", description = "REST Apis related to Employee Entity!!!!")
@RestController
public class EmployeeManagementRestController {

	@Autowired
	EmployeeRepository employeeRepository;

	@ApiOperation(value = "Get list of Employees from System ", response = Iterable.class, tags = "getEmployees")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@GetMapping(value = "/getEmployees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@ApiOperation(value = "Get specific Employee from System ", response = Employee.class, tags = "getEmployee")
	@GetMapping(value = "/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Integer id) {
		return employeeRepository.findById(id);
	}

	@ApiOperation(value = "Delete Employee from System ", response = Integer.class, tags = "deleteEmployee")
	@DeleteMapping(value = "/deleteEmployee/{id}")
	public Integer deleteEmployee(@PathVariable(value = "id") Integer id) {
		return employeeRepository.deleteById(id);
	}

	@ApiOperation(value = "Update Employee info into System ", response = Integer.class, tags = "updateEmployee")
	@PatchMapping(value = "/updateEmployee")
	public Boolean updateEmployee(@RequestBody Employee emp) {
		return employeeRepository.update(emp);
	}

	@ApiOperation(value = "Add new Employee into System ", response = Integer.class, tags = "addEmployee")
	@PostMapping(value = "/addEmployee")
	public Boolean addEmployee(@RequestBody Employee emp) {
		return employeeRepository.save(emp);
	}


}
