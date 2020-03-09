package com.pmj.teachers.repository;

import com.pmj.teachers.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    @Override
    public <S extends Teacher> S save(S s) ;

    @Override
    public Optional<Teacher> findById(Integer integer) ;

    @Override
    public List<Teacher> findAll() ;
}
