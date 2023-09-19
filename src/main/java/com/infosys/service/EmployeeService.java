package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dao.EmployeeRepository;
import com.infosys.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public boolean saveEmployee(Employee e) {
		
		return repository.saveEmployeeToDb(e);
	}
	
	public List<Employee> viewEmployee(){
		return repository.viewEmployee();
	}
}
