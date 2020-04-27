package com.pmj.students.service;

import com.pmj.students.model.Student;
import com.pmj.students.model.Telephone;
import com.pmj.students.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> findAllStudents() {

        log.info("============Log start for  all students ===========================" );
        List<Student> lst = studentRepository.findAll();
        log.info("All students : {}" , lst);
        log.info("==================Log end for all students=============================");
        return lst;


    }

    @Override
    public String saveStudent(Student studentData) {
//        System.out.println("================================================="+studentData.getEmail());

        log.info("student saved");
        for (Telephone telephone : studentData.getTelephones()) {
            telephone.setStudent(studentData);
        }
        studentData.setActive(Boolean.TRUE);
        studentRepository.save(studentData);
        return "Student Data Saved";
    }

    @Override
    public String updateStudent(Student newStudentData) {
        log.info("student updated");
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
    public List<Student> findByID(Integer id) {
        log.info("student find by ID");
        return studentRepository.findAllById(id);
    }

    //    @Override
//    public Student findByID(Integer id) {
//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent())
//            return student.get();
//        return new Student();
//    }


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
    public List<Student> getStudentsByCourseId(String id) {
        log.info("student getStudentsByCourseId");
        List<Student> student = studentRepository.findByCourseId(id);

        return student;
    }

    @Override
    public List<Student> getCourseById(String courseId) {
        log.info("student getCourseById");
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public String deleteS(Student newStudentData) {
        log.info("student deleted");
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
