package com.mangalyaspring.EmployeeApp.service;


import com.mangalyaspring.EmployeeApp.Model.Allocation;
import com.mangalyaspring.EmployeeApp.Model.Employee;
import com.mangalyaspring.EmployeeApp.Model.Telephone;
import com.mangalyaspring.EmployeeApp.histrix.AllocationCommand;
import com.mangalyaspring.EmployeeApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    public Employee save(Employee employee) {

        for (Telephone telephone : employee.getTelephones()) {
            telephone.setEmployee(employee);

        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer employeeId) {
        Optional<Employee> employees = employeeRepository.findById(employeeId);
        if (employees.isPresent())
            return employees.get();
        return new Employee();


    }

    public Employee fetchAllocation(Integer id) {

        Employee employee = this.findById(id);

        AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);

        employee.setAllocations(Arrays.asList(allocationCommand.execute()));

        return employee;
    }
}
