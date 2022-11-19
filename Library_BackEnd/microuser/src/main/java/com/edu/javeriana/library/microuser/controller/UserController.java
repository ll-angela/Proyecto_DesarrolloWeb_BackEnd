package com.edu.javeriana.library.microuser.controller;

import com.edu.javeriana.library.microuser.domain.User;
import com.edu.javeriana.library.microuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userlist")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userspaged")
    public ResponseEntity<Page<User>> pages (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc) {
        Page<User> users = userService.paged(PageRequest.of(page, size, Sort.by(order)));
        if (!asc)
            users = userService.paged(PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createuser")
    public int createUser(@RequestBody User user) {
        userService.saveUser(user);
        return user.getId();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/inactivate/{id}")
    public void inactivate(@PathVariable("id") int id) {
        userService.inactivate(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }
}
