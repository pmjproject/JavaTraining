package com.pmj.AuthMysqlNew.repository;

import com.pmj.AuthMysqlNew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);
}
