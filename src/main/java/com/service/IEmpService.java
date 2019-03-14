package com.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;

public interface IEmpService {

	String saveEmployee(Employee emp, Model model);

	String loginEmployee(Employee emp, Model model);

	String getAllEmployees(Model model);

	public String deleteUser(@RequestParam("email") String email, Model model);

	String editEmployee(Employee emp,String email, Model model);

	String updateEmployee(Employee emp, Model model);

}
