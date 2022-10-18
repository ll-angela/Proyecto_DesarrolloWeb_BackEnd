package com.edu.javeriana.library.microbook.service;

import com.edu.javeriana.library.microbook.domain.Book;
import com.edu.javeriana.library.microbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer idBook) {
        return bookRepository.findById(idBook).get();
    }

    public List<Book> getBookByName(String name) {
        return bookRepository.findByName(name);
    }

    /*public List<Book> getBooksByEditorial(String name) {
        List<Book> books = bookRepository.findAll();
        List<Book> booksByEditorial = new ArrayList<Book>();
        for(int i = 0; i<books.size(); i++) {
            booksByEditorial = bookRepository.findByEditorial(books.get(i).getEditorial_id());
        }
        return booksByEditorial;
    }*/

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int idBook) {
        bookRepository.deleteById(idBook);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

}
