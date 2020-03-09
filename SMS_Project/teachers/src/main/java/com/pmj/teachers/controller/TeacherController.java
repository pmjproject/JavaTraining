package com.pmj.teachers.controller;

import com.pmj.teachers.model.Teacher;
import com.pmj.teachers.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smsT")
public class TeacherController {

    @Autowired
    private TeachersService teachersService;
    @GetMapping("/allTeachers")
    public List<Teacher> allTeachers(){

        return teachersService.findAllTeachers();
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@RequestBody Teacher teacherData){
        return teachersService.saveTeacher(teacherData);

    }

    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody Teacher newTeacherData){
        return teachersService.updateTeacher(newTeacherData);

    }

    @GetMapping("/getTeacherByID/{id}")
    public Teacher getTeacherByID(@PathVariable Integer id){
        return teachersService.findByID(id);
    }


}
