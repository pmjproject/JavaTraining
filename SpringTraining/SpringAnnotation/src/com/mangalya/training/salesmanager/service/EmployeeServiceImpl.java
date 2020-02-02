package com.mangalya.training.salesmanager.service;


import com.mangalya.training.salesmanager.repository.EmployeeRepository;
//import com.mangalya.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.mangalya.training.salesmanager.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
//	EmployeeRepository employeeRepository = new  HibernateEmployeeRepositoryImpl();
	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		System.out.println("Default Constructor Executed");
	}
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overloaded Constructor Executed");
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeRepository getEmployeeRepository(){
		return employeeRepository;
	}
	
	
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter Injection Fired");
		
		this.employeeRepository =  employeeRepository;
	}
	
	
	
	
	 @Override
	public List<Employee> getAllEmployees(){
	        return employeeRepository.getAllEmployees();
	    }

}
