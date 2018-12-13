package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.model.Employee;
import com.nagarro.model.Manager;
import com.nagarro.service.EmployeeServiceData;
import com.nagarro.service.LoginServiceData;

@Controller
public class DataController {

	@Autowired
	public LoginServiceData loginServiceData;
	
	@Autowired
	public EmployeeServiceData employeeServiceData;
	
	@RequestMapping(value ="/manager/{user_name}", method = RequestMethod.GET)
	public @ResponseBody Manager getManager(@PathVariable("user_name") String user_name) {
		return loginServiceData.checkLogin(user_name);
	}
	@RequestMapping(value ="/manager/{user_name}/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployee(@PathVariable("user_name") String user_name) {
		return loginServiceData.getEmployees(user_name);
	}
	@RequestMapping(value ="/employee/{code}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("code") int code) {
		return employeeServiceData.getEmployee(code);
	}
	@RequestMapping(value ="/emp/create", method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		employeeServiceData.saveEmployee(emp);
		System.out.println("in data controller");
		return emp;
	}
}
