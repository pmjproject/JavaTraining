package com.pmj.profile.controller;

import com.pmj.profile.model.User;
import com.pmj.profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User fetch(@PathVariable(value = "id") int userid) {
        return userService.fetchById(userid);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<User> fetch() {
        return userService.fetchAllProfiles();
    }

}
