package com.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;

public interface IEmployee {

	void saveEmployee(Employee emp);

	List<Employee> loginEmployee(Employee emp);

	List<Employee> getAllEmployees();

	List<Employee> deleteUser(String email);

	public List<Employee> editEmployee(@RequestParam("email") String email);

	public List<Employee> updateEmployee(Employee emp);

}
