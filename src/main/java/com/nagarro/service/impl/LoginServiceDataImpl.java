package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.LoginDAO;
import com.nagarro.model.Employee;
import com.nagarro.model.Manager;
import com.nagarro.service.LoginServiceData;

@Service("loginServiceData")
public class LoginServiceDataImpl implements LoginServiceData {

	
	@Autowired
	 private LoginDAO loginDAO;
       public Manager checkLogin(String userName){
    	   return loginDAO.checkLogin(userName);
              
             
       }
	public List<Employee> getEmployees(String userName) {
		return loginDAO.getEmployees(userName);
	}
}