package com.pmj.students.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity

public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private String number2;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
   private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

}
