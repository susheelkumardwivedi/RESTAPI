package com.nagarro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.EmployeeDAO;
import com.nagarro.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }

	public Employee getEmployee(int code) {
		Session session = sessionFactory.openSession();
		Employee emp=null;
		try{
		String SQL_QUERY =" from Employee as o where o.code=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,code);
		
		List list = query.list();

		emp=(Employee)list.get(0);
		}catch(NullPointerException e){
			
		}
		catch(Exception e){
			
		}finally{
			session.close();
		}
		return emp;
	}

	public void saveEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
		session.saveOrUpdate(employee);
		transaction.commit();
		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
		session.close();
		}
		
	}

}
