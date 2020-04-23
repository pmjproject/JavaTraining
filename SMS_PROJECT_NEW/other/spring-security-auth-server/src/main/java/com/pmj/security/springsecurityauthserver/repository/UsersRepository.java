package com.pmj.security.springsecurityauthserver.repository;

import com.pmj.security.springsecurityauthserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
