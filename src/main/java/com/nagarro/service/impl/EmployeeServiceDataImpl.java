package com.nagarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.EmployeeDAO;
import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeServiceData;


@Service("employeeServiceData")
public class EmployeeServiceDataImpl implements EmployeeServiceData{

	@Autowired
	public EmployeeDAO employeeDAO;
	
	
	public Employee getEmployee(int code) {
		return employeeDAO.getEmployee(code);
	}


	public void saveEmployee(Employee employee) {
		
		employeeDAO.saveEmployee(employee);
	}

}
