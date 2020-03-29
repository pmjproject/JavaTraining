package com.pmj.students.service;

import com.pmj.students.model.Student;
import com.pmj.students.model.Telephone;
import com.pmj.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> findAllStudents() {

        return studentRepository.findAll();


    }

    @Override
    public String saveStudent(Student studentData) {
//        System.out.println("================================================="+studentData.getEmail());


        for (Telephone telephone : studentData.getTelephones()) {
            telephone.setStudent(studentData);
        }
        studentData.setActive(Boolean.TRUE);
        studentRepository.save(studentData);
        return "Student Data Saved";
    }

    @Override
    public String updateStudent(Student newStudentData) {
        String msg = null;
        if (newStudentData.getId() != 0) {
            for (Telephone telephone : newStudentData.getTelephones()) {
                telephone.setStudent(newStudentData);
            }
            newStudentData.setActive(Boolean.TRUE);
            studentRepository.save(newStudentData);
            msg = "Data Updated";
            return msg;
        } else {
            msg = "Error";
            return msg;
        }
    }

    @Override
    public Student findByID(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();
        return new Student();
    }

//    @Override
//    public Student findById(Integer id) {
//        return null;
//    }

//    public Student fetchAllocation(Integer id) {
//
//        Student student = this.findById(id);
//
//        CourseCommand courseCommand = new CourseCommand(student, httpHeaders, restTemplate);
//
//        student.setCourse(Arrays.asList(courseCommand.execute()));
//
//        return student;
//    }

//    @Override
//    public Student fetchCourse(Integer id) {
//        Student student = this.findById(id);
//
//        Course courseCommand = new Course(student, httpHeaders, restTemplate);
//
//        student.setCourse(Arrays.asList(courseCommand.execute()));
//
//        return student;
//    }

    @Override
    public List<Student> getStudentsByCourseId(Integer id) {
        List<Student> student = studentRepository.findByCourseId(id);

        return student;
    }

    @Override
    public List<Student> getCourseById(Integer courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public String deleteS(Student newStudentData) {
        String msg = null;
        if (newStudentData.getId() != 0) {
            for (Telephone telephone : newStudentData.getTelephones()) {
                telephone.setStudent(newStudentData);
            }
            newStudentData.setActive(Boolean.FALSE);

            studentRepository.save(newStudentData);
            msg = "Data Deleted";
            return msg;
        } else {
            msg = "Error";
            return msg;
        }
    }
}
