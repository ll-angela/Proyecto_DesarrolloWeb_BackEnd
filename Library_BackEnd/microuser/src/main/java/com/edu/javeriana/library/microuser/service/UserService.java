package com.edu.javeriana.library.microuser.service;

import com.edu.javeriana.library.microuser.domain.User;
import com.edu.javeriana.library.microuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> paged(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void inactivate(int idUser) {
        User auxUser = userRepository.findById(idUser).get();
        auxUser.setActive(false);
        userRepository.save(auxUser);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
