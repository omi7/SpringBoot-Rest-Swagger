package com.esolutions.employeemanagement.dao;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.esolutions.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    Logger logger = LogManager.getLogger(EmployeeRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {

        List<Employee> result = jdbcTemplate.query(
                "SELECT id, name, lastName FROM emply",
                (rs, rowNum) -> new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("lastName"))
        );
        return result;

    }

    public Employee findById(final Integer id){
        Employee result =  jdbcTemplate.queryForObject(
                "SELECT * FROM emply where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("lastName")
                        )
        );
        return  result;
    }

    public Boolean save(Employee emp) {
         int result = jdbcTemplate.update(
                "insert into emply (id,name, lastName) values(?,?,?)",
                emp.getId(),emp.getFirstName(), emp.getLastName());
         if(result>0){
            logger.info("Added Employee with ID: "+ emp.getId());
            return true;
        }
        else{
            logger.info("Employee with ID: "+ emp.getId()+ "already present");
            return false;
        }
    }

    public Boolean update(Employee emp) {
        int result =  jdbcTemplate.update(
                    "update emply set name = ?, lastName = ? where id = ?",
                    emp.getFirstName(), emp.getLastName(), emp.getId());
        if(result>0) {
            logger.info("Updated Employee with ID: " + emp.getId());
            return true;
        }
        else{
            logger.info("Cannot update Employee with ID: "+ emp.getId()+ "as no Employee found");
            return false;
        }
    }

    public int deleteById(final Integer id) {

        int result =  jdbcTemplate.update(
                "DELETE from emply where id = ?",
                id);
        if (result>0){
            logger.info("Employee deleted");
        }else{
            logger.info("Employee not found");
        }
        return result;
    }

}