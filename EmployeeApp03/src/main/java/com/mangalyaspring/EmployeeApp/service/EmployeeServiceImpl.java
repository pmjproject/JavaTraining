package com.mangalyaspring.EmployeeApp.service;


import com.mangalyaspring.EmployeeApp.Model.Employee;
import com.mangalyaspring.EmployeeApp.Model.Telephone;
import com.mangalyaspring.EmployeeApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String save(Employee employee) {
        String returnValue;
        try {
            employeeRepository.save(employee);
            returnValue = "Successfully Update";
        } catch (DataAccessException e) {
            returnValue = "Issue with Update ";
        }
        return returnValue;
    }

    @Override
    public List<Employee> FindAll() {
        return null;
    }

}
