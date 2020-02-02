package com.mangalya.training.salesmanager.service;


import com.mangalya.training.salesmanager.repository.EmployeeRepository;
import com.mangalya.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.mangalya.training.salesmanager.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeServiceImpl implements EmployeeService, EmployeeRepository {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public 	EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	public 	EmployeeServiceImpl (EmployeeRepository employeeRepository) {
		
		System.out.println("Overload Constructor executed");
		this.employeeRepository = employeeRepository;
}
	
	public EmployeeServiceImpl() {
		System.out.println("Default Constructor executed");
	}
	
	 public List<Employee> getAllEmployees(){
	        return employeeRepository.getAllEmployees();
	    }

	

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		
		System.out.println("Setter executed");
		this.employeeRepository = employeeRepository;
		
	}

}
