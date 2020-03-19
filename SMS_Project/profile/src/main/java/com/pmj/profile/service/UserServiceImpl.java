package com.pmj.profile.service;

import com.pmj.profile.model.User;
import com.pmj.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User fetchById(int userid) {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllProfiles() {
        return userRepository.findAll();
    }
}
