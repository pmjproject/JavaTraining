package com.mangalyaspring.EmployeeApp.service;

import com.mangalyaspring.EmployeeApp.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAllEmployees();
    Employee findById(Integer employeeId);
    Employee fetchAllocation(Integer id);

}
