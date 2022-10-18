package com.edu.javeriana.library.microeditorial.repository;

import com.edu.javeriana.library.microeditorial.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
}
