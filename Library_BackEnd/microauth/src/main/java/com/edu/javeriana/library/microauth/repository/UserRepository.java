package com.edu.javeriana.library.microauth.repository;

import com.edu.javeriana.library.microauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
