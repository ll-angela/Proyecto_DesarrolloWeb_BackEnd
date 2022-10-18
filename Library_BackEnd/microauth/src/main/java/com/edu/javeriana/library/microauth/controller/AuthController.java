package com.edu.javeriana.library.microauth.controller;

import com.edu.javeriana.library.microauth.domain.User;
import com.edu.javeriana.library.microauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        return authService.login(username, pwd);
    }
}
