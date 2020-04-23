package com.pmj.user.service;

import com.pmj.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    String saveUser(User userData);

    String updateTeacher(User newUserData);

    User findByID(Integer id);
}
