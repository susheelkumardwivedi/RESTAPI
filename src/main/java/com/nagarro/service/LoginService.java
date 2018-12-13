package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Employee;

public interface LoginService{    
    public boolean checkLogin(String userName, String userPassword);
    public List<Employee> getEmployees(String userName);
}