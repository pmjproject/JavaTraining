package com.pmj.course.repository;

import com.pmj.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Override
    @Query(value = "SELECT * FROM course WHERE active = 1", nativeQuery = true)
    List<Course> findAll();
//
//    @Override
//    <S extends Course> S save(S s);
//
//    @Override
//    Optional<Course> findById(Integer integer);


//    List<Course> findBycourseID(String courseID);

   // Optional<Course> findBycourseID(String courseID);

}
