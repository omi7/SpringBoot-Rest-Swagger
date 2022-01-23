package com.esolutions.employeemanagement.dao;

import com.esolutions.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(final Integer id);

    Boolean save(Employee emp);

    Boolean update(Employee emp);

    int deleteById(final Integer id);
}
