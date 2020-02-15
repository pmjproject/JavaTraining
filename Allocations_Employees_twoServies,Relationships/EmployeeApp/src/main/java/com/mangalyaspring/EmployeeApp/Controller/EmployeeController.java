package com.mangalyaspring.EmployeeApp.Controller;

import com.mangalyaspring.EmployeeApp.Model.Employee;
import com.mangalyaspring.EmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")


public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employee/allocation")
    public <Allocation> List<Allocation> getEmployeesAllocation() {
        return employeeService.fetchAllocation();
    }

}
