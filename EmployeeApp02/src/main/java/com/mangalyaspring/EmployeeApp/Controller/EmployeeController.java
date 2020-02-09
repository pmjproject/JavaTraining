package com.mangalyaspring.EmployeeApp.Controller;

import com.mangalyaspring.EmployeeApp.Model.Employee;
import com.mangalyaspring.EmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/services")
@XmlRootElement

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping(value = "/employee")
    public Employee save (@RequestBody Employee employee){
        return employeeService.save(employee);
    }


}
