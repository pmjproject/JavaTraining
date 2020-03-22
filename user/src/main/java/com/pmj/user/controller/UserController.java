package com.pmj.user.controller;

import com.pmj.user.model.User;
import com.pmj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smsU")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/allUsers")
    public List<User> allUsers(){

        return userService.findAllUsers();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User userData){
        return userService.saveUser(userData);

    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User newUserData){
        return userService.updateTeacher(newUserData);

    }

    @GetMapping("/getUserByID/{id}")
    public User getUserByID(@PathVariable Integer id){
        return userService.findByID(id);
    }


}


