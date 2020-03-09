package com.pmj.teachers.service;

import com.pmj.teachers.model.Teacher;
import com.pmj.teachers.model.Telephone;
import com.pmj.teachers.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeachersService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public String saveTeacher(Teacher teacherData) {

        for (Telephone telephone: teacherData.getTelephones()){
            telephone.setTeacher(teacherData);
        }

        teacherRepository.save(teacherData);
        return " Data Saved";
    }

    @Override
    public String updateTeacher(Teacher newTeacherData) {
        String msg = null;
        if (newTeacherData.getId() != 0){
            for (Telephone telephone: newTeacherData.getTelephones()){
                telephone.setTeacher(newTeacherData);
            }

            teacherRepository.save(newTeacherData);
            msg = "Data Saved";
            return msg;
        }
        else {
            msg = "Error";
            return msg;
        }
    }

    @Override
    public Teacher findByID(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent())
            return teacher.get();
        return new Teacher();
    }
}