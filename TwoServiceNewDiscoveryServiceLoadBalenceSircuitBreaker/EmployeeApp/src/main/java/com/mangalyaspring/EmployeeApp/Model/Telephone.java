package com.mangalyaspring.EmployeeApp.Model;

import lombok.Data;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    private  Integer number;

    @ManyToOne
    @JoinColumn
//    @JsonIgnore
    Employee employee;

    public Telephone(Integer number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getNumber() {
//        return number;
//    }
//
//    public void setNumber(Integer number) {
//        this.number = number;
//    }
//
//
//    public void setEmployee(Employee employee) {
//    }
}
