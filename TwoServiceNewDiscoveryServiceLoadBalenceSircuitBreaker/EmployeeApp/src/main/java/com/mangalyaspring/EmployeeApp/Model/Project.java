package com.mangalyaspring.EmployeeApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "projects",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

}
