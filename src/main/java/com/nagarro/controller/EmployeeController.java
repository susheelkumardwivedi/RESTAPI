package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;
import com.nagarro.service.LoginService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int codeId= Integer.parseInt(request.getParameter("code"));
	    Employee employee=employeeService.getEmployee(codeId);
	    ModelAndView model = new ModelAndView("employee");
	    model.addObject("employee",employee);
	 
	    return model;
	}
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Employee newEmployee = new Employee();
	    model.addObject("employee",newEmployee);
	    model.setViewName("employee");
	    return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveContact(@Valid Employee employee) {
	    employeeService.saveEmployee(employee);
	    
	    ModelAndView map = new ModelAndView("employeeList");
		List<Employee> list=loginService.getEmployees(employee.getManager());
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("hello");
			System.out.println(list.get(i).getName());
		}
		map.addObject("user",employee.getManager());
		map.addObject("inf",list);
		
		return map;
	}
}
