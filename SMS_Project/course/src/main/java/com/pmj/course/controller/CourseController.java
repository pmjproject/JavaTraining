package com.pmj.course.controller;


import com.pmj.course.model.Course;
import com.pmj.course.model.Student;
import com.pmj.course.model.Teacher;
import com.pmj.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smsC")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/allCourse")
    public List<Course> allCourse(){

        return courseService.findAllCourse();
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course courseData){
        return courseService.saveCourse(courseData);

    }

    @PutMapping("/updateCourse")
    public String updateCourse(@RequestBody Course newCourseData){
        return courseService.updateCourse(newCourseData);

    }

    @GetMapping("/getCourseByID/{id}")
    public Course getCourseByID(@PathVariable Integer id){
        return courseService.findByID(id);
    }

//    @RequestMapping(value = "course/findByStudentId/{studentId}", method = RequestMethod.GET)
//    public List<Course> getCourseByStudentId(@PathVariable Integer studentId) {
//        System.out.println("#######################2");
//        return courseService.getCourseByStudentId(studentId);
//    }


    @GetMapping("courseStudent/{courseId}")
    public List<Student> fetchStudents(@PathVariable Integer courseId){
        return courseService.fetchStudents(courseId);
    }

    @GetMapping("courseTeacher/{courseId}")
    public List<Teacher> fetchTeachers(@PathVariable Integer courseId){
        return courseService.fetchTeachers(courseId);
    }





}
