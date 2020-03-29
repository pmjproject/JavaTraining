package com.pmj.students.service;

import com.pmj.students.model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentService {

//    @Query(value = "SELECT * FROM student WHERE active = 1", nativeQuery = true)
    List<Student> findAllStudents();

    String saveStudent(Student studentData);

    String updateStudent(Student newStudentData);

    Student findByID(Integer id);

    List<Student> getStudentsByCourseId(Integer id);

    List<Student> getCourseById(Integer courseId);

    String deleteS(Student newStudentData);


//    Student fetchAllocation(Integer id);

//    Student findById(Integer id);
//
//    Student fetchCourse(Integer id);
}
