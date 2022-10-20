package com.edu.javeriana.library.microbook.repository;

import com.edu.javeriana.library.microbook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);
    //List<Book> findByEditorial(String name);
}
