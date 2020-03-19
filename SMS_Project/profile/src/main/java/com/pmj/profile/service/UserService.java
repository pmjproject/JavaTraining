package com.pmj.profile.service;

import com.pmj.profile.model.User;

import java.util.List;

public interface UserService  {
    User fetchById(int userid);

    User save(User user);

    List<User> fetchAllProfiles();
}
