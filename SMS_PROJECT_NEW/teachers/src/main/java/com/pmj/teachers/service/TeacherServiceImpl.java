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
        teacherData.setActive(Boolean.TRUE);
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
            newTeacherData.setActive(Boolean.TRUE);
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
    public List<Teacher> findByID(Integer id) {
        return teacherRepository.findAllById(id);
    }

    @Override
    public List<Teacher> getCourseById(String courseId) {
        List<Teacher> teachersLst =  teacherRepository.findByCourseID(courseId);
        return teachersLst;
    }

    @Override
    public String deleteT(Teacher newTeacherData) {
        String msg = null;
        if (newTeacherData.getId() != 0) {

            newTeacherData.setActive(Boolean.FALSE);

            teacherRepository.save(newTeacherData);
            msg = "Data Deleted";
            return msg;
        } else {
            msg = "Error";
            return msg;
        }
    }
}