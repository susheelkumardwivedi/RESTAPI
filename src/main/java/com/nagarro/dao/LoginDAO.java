package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Employee;
import com.nagarro.model.Manager;

public interface LoginDAO{    
    public Manager checkLogin(String userName);
    public List<Employee> getEmployees(String userName);
}
