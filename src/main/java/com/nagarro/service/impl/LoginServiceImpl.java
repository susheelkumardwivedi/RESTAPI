package com.nagarro.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Employee;
import com.nagarro.model.Manager;
import com.nagarro.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private static final String SERVER_URI = "http://localhost:8080/RestApp";
      
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              RestTemplate restTemplate = new RestTemplate();
              Manager mg = restTemplate.getForObject(SERVER_URI+"/manager/"+userName, Manager.class);
              if(mg!=null&&mg.getPassword().equals(userPassword))
            	  return true;
              else return false;
              
             
       }

	public List<Employee> getEmployees(String userName) {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+"/manager/"+userName+"/getAll", List.class);
		List<Employee> list =new LinkedList<Employee>();
		for(LinkedHashMap map : emps){
			Employee temp=new Employee();
			temp.setCode((Integer)map.get("code"));
			temp.setDob(String.valueOf(map.get("dob")));
			temp.setEmail(String.valueOf(map.get("email")));
			temp.setLocation(String.valueOf(map.get("location")));
			temp.setManager(String.valueOf(map.get("manager")));
			temp.setName(String.valueOf(map.get("name")));
			
			list.add(temp);
		}
		
		return list;
	}
}