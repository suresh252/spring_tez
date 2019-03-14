package com.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.IEmployee;
import com.dbutil.HiberDbUtil;
import com.model.Employee;

public class EmployeeDaoImpl implements IEmployee {
	final static Logger logger=Logger.getLogger(IEmployee.class);

	public void saveEmployee(Employee emp) {
		logger.info("Entered into saveEmployee::EmployeeDaoImpl");
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();
		session.save(emp);
		session.beginTransaction().commit();
		logger.info("SAVE EMPLOYEE");
	}

	public List<Employee> loginEmployee(Employee emp) {
		logger.info("Entered into LoginEmployee::EmployeeDaoImpl");
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where email=:mail AND password=:password");
		query.setParameter("mail", emp.getEmail());
		query.setParameter("password", emp.getPassword());
		List<Employee> list = query.list();

		for (Employee employee : list) {
			System.out.println("=====================" + employee.getEmpname());
		}
		// List<Employee> list2 = getAllEmployees(emp);
		logger.info("Exited from LoginEmployee::EmployeeDaoImpl");
		return list;

	}

	public List<Employee> getAllEmployees() {
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();

		Query queryAll = session.createQuery("from Employee");
		List<Employee> EmployeeList = queryAll.list();

		return EmployeeList;
	}

	public List<Employee> deleteUser(String email) {
		logger.info("Entered into deleteUser::EmployeeDaoImpl");
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("delete from Employee where email=:email");
		query.setParameter("email", email);
		int executeUpdate = query.executeUpdate();
		session.beginTransaction().commit();
		logger.info("===========" + executeUpdate);

		Query queryAll = session.createQuery("from Employee");
		List<Employee> list = queryAll.list();

		logger.info("Exited from deleteUser::EmployeeDao");

		return list;
	}

	public List<Employee> editEmployee(@RequestParam("email") String email) {
		logger.info("Entered into editEmployee::EmployeeDaoImpl");
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where email =:email");

		query.setParameter("email", email);
		List<Employee> employeeList = query.list();

		return employeeList;
	}

	public List<Employee> updateEmployee(Employee emp) {
		logger.info("Entered into updateEmployee::EmployeeDaoImpl");
		SessionFactory sf = HiberDbUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session
				.createQuery("update Employee set empname=:name, company=:comp, password=:pswd where email=:mail");
		query.setParameter("name", emp.getEmpname());
		query.setParameter("comp", emp.getCompany());
		query.setParameter("mail", emp.getEmail());
		query.setParameter("pswd", emp.getPassword());
		int result = query.executeUpdate();
		session.beginTransaction().commit();
		logger.info(result);

		Query queryAll = session.createQuery("from Employee");
		List<Employee> employeeList = queryAll.list();

		return employeeList;
	}

}
