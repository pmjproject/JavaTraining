package com.mangalya.training.salesmanager.repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mangalya.training.salesmanager.model.Employee;


@Repository("you-can-use-any name")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	@Override
	public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeName("Mangalya");
        employee.setEmployeeLocation("Padukka");
        employees.add(employee);
        return employees;
    }

}
