package com.pmj.course.service;

import com.pmj.course.model.Course;
import com.pmj.course.model.Student;
import com.pmj.course.model.Teacher;
import com.pmj.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public String saveCourse(Course courseData) {

//        for (Course telephone: teacherData.getTelephones()){
//            telephone.setTeacher(teacherData);
//        }
        courseData.setActive(Boolean.TRUE);

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

            newCourseData.setActive(Boolean.TRUE);

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

    @Override
    public Course getCoursesByID(Integer courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent())
            return course.get();
        return null;
    }

    @Override
    public List<Student> fetchStudents(Integer courseId) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        ResponseEntity<Student[]> result=restTemplate.exchange("http://student/sms/studentsC/"+courseId,
                HttpMethod.GET,httpEntity,Student[].class);

        Student[] resultBody = result.getBody();
        List<Student> students = new ArrayList<>();

        for (Student student : resultBody) {
            student.setCourse(this.getCoursesByID(student.getCourseId()));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Teacher> fetchTeachers(Integer courseID) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        ResponseEntity<Teacher[]> result=restTemplate.exchange("http://teacher/smsT/teacherC/"+courseID,
                HttpMethod.GET,httpEntity,Teacher[].class);

        Teacher[] resultBody = result.getBody();
        List<Teacher> teachers = new ArrayList<>();

        for (Teacher teacher : resultBody) {
            teacher.setCourse(this.getCoursesByIDTeacher(teacher.getCourseID()));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public Course getCoursesByIDTeacher(Integer courseID) {
        Optional<Course> course = courseRepository.findById(courseID);
        if (course.isPresent())
            return course.get();
        return null;
    }

    @Override
    public String deleteC(Course newCourseData) {
        String msg = null;
        if (newCourseData.getId() != 0) {

            newCourseData.setActive(Boolean.FALSE);

            courseRepository.save(newCourseData);
            msg = "Data Deleted";
            return msg;
        } else {
            msg = "Error";
            return msg;
        }
    }


//    @Override
//    public List<Course> getCourseByStudentId(Integer studentId) {
//        return courseRepository.findByStudentID(studentId);
//    }
}