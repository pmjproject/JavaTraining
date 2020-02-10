package com.mangalyaspring.EmployeeApp.service;

import com.mangalyaspring.EmployeeApp.Model.Employee;

import java.util.List;

public interface EmployeeService {
    String save(Employee employee);

    List<Employee> FindAll();
}
