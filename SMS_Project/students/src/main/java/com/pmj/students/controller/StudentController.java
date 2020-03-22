package com.pmj.students.controller;


import com.pmj.students.model.Student;
import com.pmj.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sms")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/allStudents")
    public List<Student> allStudents(){

        return studentService.findAllStudents();
    }

    @PostMapping("/addStudent")
    public String addStudents(@RequestBody Student studentData){
        return studentService.saveStudent(studentData);

    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student newStudentData){
        return studentService.updateStudent(newStudentData);

    }
    @PutMapping("/deleteS")
    public String deleteS(@RequestBody Student newStudentData){
        return studentService.deleteS(newStudentData);

    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentByID(@PathVariable Integer id){
        return studentService.findByID(id);
    }


//    @RequestMapping("/student/course/{id}")
//    public Student getFetchAllCourse(@PathVariable Integer id) {
//
//        return studentService.fetchCourse(id);
//    }
//    @RequestMapping("/student/{id}")
//    public List<Student> getStudentsByCourseId(@PathVariable Integer id){
//    return studentService.getStudentsByCourseId(id);
//}

    @GetMapping("/studentsC/{id}")
    public List<Student> getCourseById(@PathVariable("id") Integer courseId){
        System.out.println("request came on "+ LocalDateTime.now() + "  ++++++++++++++++++++++");
        return studentService.getCourseById(courseId);
    }


}
