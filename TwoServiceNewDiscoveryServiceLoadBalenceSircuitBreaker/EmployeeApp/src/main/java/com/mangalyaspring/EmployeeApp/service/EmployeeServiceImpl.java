package com.mangalyaspring.EmployeeApp.service;


import com.mangalyaspring.EmployeeApp.Model.Allocation;
import com.mangalyaspring.EmployeeApp.Model.Employee;
import com.mangalyaspring.EmployeeApp.Model.Telephone;
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
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    RestTemplate restTemplateBuilder (RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }

    @Autowired
    EmployeeRepository employeeRepository;



    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    @Value("${service.host}")
    private String allocationServiceHost;

    @Value("${service.allocation.findAll}")
    private String findAll;

    @Value("${service.allocation.findByEmployeeId}")
    private String findByEmployeeIdURI;

    public Employee save(Employee employee) {


//        for (Telephone telephone : employee.getTelephones()) {
//            telephone.setEmployee(employee);
//
//        }


        return employeeRepository.save(employee);
    }

//    @Override
//    public List<Employee> FindAll() {
//        return null;
//    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer employeeId) {
        Optional<Employee> employees = employeeRepository.findById(employeeId);
        if (employees.isPresent())
            return employees.get();
        return null;


    }

    @Override
    public Employee fetchAllocation(Integer id) {
        return null;
    }

    public List<Allocation> fetchAllocation() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Allocation[]> result = restTemplate.getForEntity(allocationServiceHost + findAll, Allocation[].class);

        Allocation[] resultBody = result.getBody();

        List<Allocation> allocations = new ArrayList<>();

        for (Allocation allocation : resultBody) {
            allocation.setEmployee(this.findById(allocation.getEmpId()));
            allocations.add(allocation);
        }


        return allocations;
    }

}
