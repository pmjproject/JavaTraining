package com.pmj.user.service;


import com.pmj.user.model.User;
import com.pmj.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String saveUser(User userData) {
        userRepository.save(userData);
        return " Data Saved";
    }

    @Override
    public String updateTeacher(User newUserData) {
        String msg = null;
        if (newUserData.getId() != 0){


            userRepository.save(newUserData);
            msg = "Data Saved";
            return msg;
        }
        else {
            msg = "Error";
            return msg;
        }
    }

    @Override
    public User findByID(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        return new User();
    }
}
