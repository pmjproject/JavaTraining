package com.pmj.students.service;

import com.pmj.students.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    String saveStudent(Student studentData);

    String updateStudent(Student newStudentData);

    Student findByID(Integer id);

//    Student fetchAllocation(Integer id);

//    Student findById(Integer id);
//
//    Student fetchCourse(Integer id);
}
