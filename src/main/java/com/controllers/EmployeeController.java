package com.controllers;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;
import com.model.Student;
import com.service.IEmpService;

@Controller
public class EmployeeController {
	final static Logger logger = Logger.getLogger(EmployeeController.class);
	@Autowired
	private IEmpService empService;
	@Autowired
	Student emp1;
	@Autowired
	Student emp2;

	@RequestMapping(value = "/testioc", method = RequestMethod.POST)
	public String saveEmployee(Employee emp, Model model) {
		System.out.println("Entered into saveEmployee:: EmployeeController");

		logger.info("=========IOC TEST ============");
		emp1.setStdName("Shiva");
		emp1.getPan().setPanCardNo("ADID123");
		emp1.getPan().setIssuedDate(new Date());
		emp2.setStdName("Suresh");
		emp2.getPan().setPanCardNo("SDID167");
		emp2.getPan().setIssuedDate(new Date());
		logger.info("EMP Name : " + emp1.getStdName() + "PAN Card NO: " + emp1.getPan().getPanCardNo());
		logger.info("EMP Name : " + emp2.getStdName() + "PAN Card NO: " + emp2.getPan().getPanCardNo());
		logger.info("==========IOC END =============");

		String saveEmployee = empService.saveEmployee(emp, model);
		return saveEmployee;
	}

	/*@RequestMapping(value = "/loginemp", method = RequestMethod.POST)
	public String loginEmployee(Employee emp, Model model) {

		System.out.println("Entered into loginEmployee:: EmployeeController");

		String loginEmployee = empService.loginEmployee(emp, model);
		empService.getAllEmployees(model);

		// model.addAttribute("employee",loginEmployee);

		return loginEmployee;
	}
*/	
	@RequestMapping(value = "/getEmployees")
	public String getEmployees(Model model) {

		empService.getAllEmployees(model);

		// model.addAttribute("employee",loginEmployee);

		return "profile";
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
	public String getAllEmployees(Employee emp, Model model) {
		logger.info("Entered into getEmployees::EmployeeController");

		String getAllEmployees = empService.getAllEmployees(model);
		model.addAttribute("empList", getAllEmployees);

		return getAllEmployees;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("email") String email, Model model) {
		logger.info("Entered into deleteUser::EmployeeController");
		String deleteUser = empService.deleteUser(email, model);
		logger.info(deleteUser);

		return deleteUser;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@RequestParam("email") String email, Model model, Employee emp) {
		logger.info("Entered into editEmployee::EmployeeController");
		String editEmployee = empService.editEmployee(emp, email, model);

		return editEmployee;
	}
		@RequestMapping(value="/update", method=RequestMethod.POST)
		public String updateEmployee(Employee emp, Model model) {
			logger.info("Entered into updateEmployee:: EmployeeController");
			String updateEmployee = empService.updateEmployee(emp,model);
			
			return updateEmployee;
			//
		}
}
