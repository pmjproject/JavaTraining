package com.pmj.course.service;

import com.pmj.course.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourse();

    String saveCourse(Course courseData);

    String updateCourse(Course newCourseData);

    Course findByID(Integer id);

//    List<Course> getCourseByStudentId(Integer studentId);
}
