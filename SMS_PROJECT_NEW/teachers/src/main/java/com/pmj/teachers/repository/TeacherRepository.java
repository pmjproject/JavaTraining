package com.pmj.teachers.repository;

import com.pmj.teachers.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    @Override
    public <S extends Teacher> S save(S s) ;


    List<Teacher> findAllById(Integer id);

    @Override
    @Query(value = "SELECT * FROM teacher WHERE active = 1", nativeQuery = true)
    public List<Teacher> findAll() ;


    List<Teacher> findByCourseID(String courseId);
}
