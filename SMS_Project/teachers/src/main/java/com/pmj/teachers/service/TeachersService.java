package com.pmj.teachers.service;

import com.pmj.teachers.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeachersService {

    List<Teacher> findAllTeachers();

    String saveTeacher(Teacher teacherData);

    String updateTeacher(Teacher newTeacherData);

    Teacher findByID(Integer id);

    List<Teacher> getCourseById(Integer courseId);
}
