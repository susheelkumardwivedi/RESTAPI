package com.nagarro.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private static final String SERVER_URI = "http://localhost:8080/RestApp";
	
	public Employee getEmployee(int code) {
		 RestTemplate restTemplate = new RestTemplate();
         Employee emp = restTemplate.getForObject(SERVER_URI+"/employee/"+code,Employee.class);
         return emp;
	}

	public void saveEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		Employee response = restTemplate.postForObject(SERVER_URI+"/emp/create", employee, Employee.class);
		System.out.println("employee saved");
		
	}

}
