package com.pmj.students.repository;

import com.pmj.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Override
    public <S extends Student> S save(S s);


    @Override
    Optional<Student> findById(Integer id);


    @Override
    @Query(value = "SELECT * FROM student WHERE active = 1", nativeQuery = true)
    public List<Student> findAll();


    public List<Student> findByCourseId(String id);

    List<Student> findAllById(Integer id);

}
