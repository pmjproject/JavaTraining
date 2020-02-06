package com.mangalyaspring.EmployeeApp.Controller;

import com.mangalyaspring.EmployeeApp.Model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/services")
@XmlRootElement

public class EmployeeController {

    @RequestMapping("/employee")
    public List<Employee> getEmployees(){
        return Employee.getAllEmployees();
    }
}
