package com.mangalya.training.salesmanager.repository;

import java.util.List;

import com.mangalya.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}