package com.mangalya.training.salesmanager.service;


import com.mangalya.training.salesmanager.repository.EmployeeRepository;
import com.mangalya.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.mangalya.training.salesmanager.model.Employee;

import java.util.List;


public class EmployeeServiceImpl {
	
	EmployeeRepository employeeRepository = new  HibernateEmployeeRepositoryImpl();
	
	 public List<Employee> getAllEmployees(){
	        return employeeRepository.getAllEmployees();
	    }

}
