package com.esolutions.employeemanagement;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {


	private static final Logger log = LogManager.getLogger(EmployeeManagementApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("StartApplication...");
		runJDBC();
	}

	void runJDBC() {

		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE IF EXISTS emply");
		jdbcTemplate.execute("CREATE TABLE emply(" +
				"id int NOT NULL UNIQUE, name varchar(25), lastName varchar(25))");
	}
}
