package com.pmj.students.repository;

import com.pmj.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
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
    public List<Student> findAll();


}
