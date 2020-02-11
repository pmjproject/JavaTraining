package com.mangalyaspring.EmployeeApp.service;

import com.mangalyaspring.EmployeeApp.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> FindAll();

    List<Employee> getAllEmployees();

    <Allocation> List<Allocation> fetchAllocation();

    Employee findById(Integer employeeId);

}
