package com.mangalyaspring.EmployeeApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Allocation {

    private Integer id;
    private String startDate;
    private String endDate;
    private String projectCode;
    @JsonIgnore
    private Integer empId;

    private Employee employee;

    public Integer getEmpId() {
        return null;
                
    }

    public void setEmployee(Employee byId) {
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public Integer getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Integer empId) {
//        this.empId = empId;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(String endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getProjectCode() {
//        return projectCode;
//    }
//
//    public void setProjectCode(String projectCode) {
//        this.projectCode = projectCode;
//    }
}
