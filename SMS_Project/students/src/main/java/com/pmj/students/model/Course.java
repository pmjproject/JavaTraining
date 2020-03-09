package com.pmj.students.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class Course {

    private Integer id;
    private String course_name;
    private String course_code;

    @JsonIgnore
    private Integer studentId;

//    public Course(Student student, HttpHeaders httpHeaders, RestTemplate restTemplate) {
//    }


}
