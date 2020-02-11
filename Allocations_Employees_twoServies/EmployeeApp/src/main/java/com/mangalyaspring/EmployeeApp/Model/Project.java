package com.mangalyaspring.EmployeeApp.Model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer id;
    private String project;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    List<Employee> employee;

    public Project(String project, List<Employee> employee) {
        this.project = project;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


}
