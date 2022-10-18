package com.edu.javeriana.library.microuser.controller;

import com.edu.javeriana.library.microuser.domain.User;
import com.edu.javeriana.library.microuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/createuser")
    public int createUser(@RequestBody User user) {
        userService.saveUser(user);
        return user.getId();
    }

    @PutMapping("/inactivate/{id}")
    public void inactivate(@PathVariable("id") int id) {
        userService.inactivate(id);
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }
}
