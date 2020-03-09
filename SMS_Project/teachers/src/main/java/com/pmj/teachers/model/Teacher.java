package com.pmj.teachers.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String dob;
    private String teacherCode;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Telephone> telephones;
}
