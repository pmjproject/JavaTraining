package com.pmj.course.service;

import com.pmj.course.model.Course;
import com.pmj.course.model.Student;
import com.pmj.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public String saveCourse(Course courseData) {

//        for (Course telephone: teacherData.getTelephones()){
//            telephone.setTeacher(teacherData);
//        }

        courseRepository.save(courseData);
        return " Data Saved";
    }

    @Override
    public String updateCourse(Course newCourseData) {
        String msg = null;
        if (newCourseData.getId() != 0){
//            for (Telephone telephone: newTeacherData.getTelephones()){
//                telephone.setTeacher(newTeacherData);
//            }

            courseRepository.save(newCourseData);
            msg = "Data Saved";
            return msg;
        }
        else {
            msg = "Error";
            return msg;
        }
    }

    @Override
    public Course findByID(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent())
            return course.get();
        return new Course();
    }



//    @Override
//    public List<Course> getCourseByStudentId(Integer studentId) {
//        return courseRepository.findByStudentID(studentId);
//    }
}