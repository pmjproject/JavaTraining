package com.mangalyaspring.EmployeeApp.Model;




import java.util.ArrayList;
import java.util.List;

public class Employee {


    private String name;
    private int marks;
    
    public Employee(String name,int marks){
        this.name = name;
        this.marks =marks;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        
        employeeList.add(new Employee("mangalya",  87));
        employeeList.add(new Employee("nimal",  45));
        employeeList.add(new Employee( "kama",  67));
        employeeList.add(new Employee("ruby",  78));
        
        return employeeList;
    }
}
