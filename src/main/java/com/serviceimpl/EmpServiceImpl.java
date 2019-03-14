package com.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.dao.IEmployee;
import com.model.Employee;
import com.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	final static Logger logger=Logger.getLogger(IEmpService.class);
	@Autowired
	private IEmployee empDao;

	public String saveEmployee(Employee emp, Model model) {
		empDao.saveEmployee(emp);
		
			
			model.addAttribute("sms", "Registration successful!!");
		
		return "home";
	}

	public String loginEmployee(Employee emp, Model model) {
		logger.info("Entered into LoginEmployee::EmpServiceImpl");
		List<Employee> list = empDao.loginEmployee(emp);
		if (list.isEmpty()) {
			model.addAttribute("sms", "please try again with valid credentials");
			return "login";
		}
		model.addAttribute("empList", list);
		logger.info("Exited from LoginEmployee::EmpServiceImpl");
		return "profile";
	}

	public String getAllEmployees(Model model) {
		logger.info("Entered into getAllEmployees::EmpServiceImpl");
		List<Employee> employeeList = empDao.getAllEmployees();
		model.addAttribute("empList", employeeList);
		logger.info("Exited from getAllEmployees::EmpServiceImpl");
		return "profile";

	}

	public String deleteUser(String email, Model model) {
		logger.info("Entered into deleteUser::EmpServiceImpl");
		List<Employee> deleteUser = empDao.deleteUser(email);
		model.addAttribute("empList", deleteUser);

		logger.info("Exited from deleteUser::EmpServiceImpl");
		return "profile";
	}

	

	public String editEmployee(Employee emp,String email, Model model) {
		logger.info("Entered into editEmployee::EmpServiceImpl");
		List<Employee> editEmployee = empDao.editEmployee(email);
		model.addAttribute("empList",editEmployee);
		
		return "update";
	}

	public String updateEmployee(Employee emp, Model model) {
		logger.info("Entered into updateEmployee::EmpServiceImpl");
		List<Employee> updateEmployee = empDao.updateEmployee(emp);
		model.addAttribute("empList",updateEmployee );
		return "profile";
	}
}