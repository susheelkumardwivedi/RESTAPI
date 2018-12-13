package com.nagarro.service;

import com.nagarro.model.Employee;

public interface EmployeeServiceData {

	public Employee getEmployee(int code);
	public void saveEmployee(Employee employee);
}
