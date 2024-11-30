package com.jpa.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.practice.model.DemoDTO;
import com.jpa.practice.model.Employee;
import com.jpa.practice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaService {
	private static final Logger log = LoggerFactory.getLogger(JpaService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public void save() throws JsonProcessingException {
		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setName("Test");
		demoDTO.setSalary("50K");

		ObjectMapper map = new ObjectMapper();

		Employee emp = new Employee();
		emp.setRequest(map.writeValueAsString(demoDTO));

		employeeRepository.save(emp);

		log.info("Employee saved successfully into database with id {}", emp.getId());
	}

}