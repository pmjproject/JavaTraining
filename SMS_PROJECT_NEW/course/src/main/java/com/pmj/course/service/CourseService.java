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

    List<Student> fetchStudents(Integer courseId);

    List<Teacher> fetchTeachers(Integer courseID);

    Course getCoursesByIDTeacher(Integer courseID);

    String deleteC(Course newCourseData);


//    List<Course> getCourseByStudentId(Integer studentId);
}
