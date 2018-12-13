package com.nagarro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.LoginDAO;
import com.nagarro.model.Employee;
import com.nagarro.model.Manager;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public Manager checkLogin(String userName){
			Session session = sessionFactory.openSession();
			Manager mg=null;
			try{
			String SQL_QUERY =" from Manager as o where o.username=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			
			List list = query.list();
			mg=(Manager)list.get(0);
			}catch(NullPointerException e){
				
			}catch(Exception e){
				
			}finally{
			session.close();
			}
			return mg;              
       }

	public List<Employee> getEmployees(String userName) {
		Session session=sessionFactory.openSession();
		List<Employee> list=null;
		try{
		String SQL_QUERY = " from Employee as e where e.manager=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,userName);
		list=query.list();
		}catch(NullPointerException e){
			
		}catch(Exception e){
			
		}finally{
		session.close();
		}
		return list;
	}
}