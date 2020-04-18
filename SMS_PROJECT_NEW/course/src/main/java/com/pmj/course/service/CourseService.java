package com.pmj.course.service;

import com.pmj.course.model.Course;
import com.pmj.course.model.Student;
import com.pmj.course.model.Teacher;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourse();

    String saveCourse(Course courseData);

    String updateCourse(Course newCourseData);

    Course findByID(Integer id);



    Course getCoursesByID(Integer courseId);

    List<Student> fetchStudents(String courseId);

    List<Teacher> fetchTeachers(String courseID);

    //Course getCoursesByIDTeacher(String courseID);

    String deleteC(Course newCourseData);


//    List<Course> getCourseByStudentId(Integer studentId);
}
