package com.mangalya.training.salesmanager.service;


import com.mangalya.training.salesmanager.repository.EmployeeRepository;
//import com.mangalya.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.mangalya.training.salesmanager.model.Employee;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {
	
//	EmployeeRepository employeeRepository = new  HibernateEmployeeRepositoryImpl();
	
	private EmployeeRepository employeeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		
		this.employeeRepository =  employeeRepository;
	}
	
	 @Override
	public List<Employee> getAllEmployees(){
	        return employeeRepository.getAllEmployees();
	    }

}
