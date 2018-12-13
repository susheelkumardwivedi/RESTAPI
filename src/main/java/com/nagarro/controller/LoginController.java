package com.nagarro.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Employee;
import com.nagarro.service.LoginService;
import com.nagarro.util.LoginForm;

@Controller
@RequestMapping(value="login")
public class LoginController {
	
	@Autowired
	public LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String,Object> model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid LoginForm loginForm, BindingResult result,
			Map<String,Object> model) {

		
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		
		
		if(loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword())){
			ModelAndView map = new ModelAndView("employeeList");
			List<Employee> list=loginService.getEmployees(loginForm.getUserName());
			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				System.out.println("hello");
				System.out.println(list.get(i).getDob());
			}
			map.addObject("user",loginForm.getUserName());
			map.addObject("inf",list);
			
			return map;
		}
		else {
			return new ModelAndView("login");
		}
		
		

	}
}
