package com.infosys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.entity.Employee;
import com.infosys.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping("/saveEmployee")
	public ModelAndView saveEmployee(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("salary") String salary ) {
		
		String msg ;
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAddress(address);
		emp.setSalary(Integer.parseInt(salary));
		
		if(service.saveEmployee(emp)) {
			 msg = "employee saved successfully";
		}
		else {
			 msg= "Employee not saved to Db due to some error";
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("msg", msg);
		
		return new ModelAndView("success", map);
		
	}
	
	@RequestMapping("/viewAllEmployees")
	public ModelAndView showAllEmployee()
	{
		List<Employee> elist = service.viewEmployee();
		
		Map<String, List<Employee>> map = new HashMap<>();
		map.put("empList", elist);
		
		return new ModelAndView("ShowEmpList", map);
	}
}
