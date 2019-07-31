package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @PostMapping("/addNewUser")
    public User save (@RequestBody User user){

        System.out.println(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (this.userService.save(user)) {
            return user;
        }
        else return null;
    }






}
