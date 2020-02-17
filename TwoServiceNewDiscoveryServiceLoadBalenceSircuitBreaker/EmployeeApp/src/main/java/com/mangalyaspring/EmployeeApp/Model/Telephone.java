package com.mangalyaspring.EmployeeApp.Model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    private Employee employee;

}

