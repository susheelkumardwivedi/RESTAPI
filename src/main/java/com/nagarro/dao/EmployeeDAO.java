package com.nagarro.dao;

import com.nagarro.model.Employee;

public interface EmployeeDAO {

	public Employee getEmployee(int code);
	public void saveEmployee(Employee employee);
}
