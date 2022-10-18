package com.edu.javeriana.library.microbook.controller;

import com.edu.javeriana.library.microbook.domain.Book;
import com.edu.javeriana.library.microbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/booklist")
    public List<Book> findAllBooks() {

        return bookService.findAllBooks();
    }

    @GetMapping("/book/{idBook}")
    private Book getBooks(@PathVariable("idBook") Integer idBook)
    {
        return bookService.getBookById(idBook);
    }

    @GetMapping("/bookname/{bookName}")
    private List<Book> findByName(@PathVariable("bookName") String bookName) {
        return bookService.getBookByName(bookName);
    }

    /*@GetMapping("/bookeditorial/{editorialName}")
    private List<Book> findByEditorial(@PathVariable("editorialName") String editorialName) {
        return bookService.getBooksByEditorial(editorialName);
    }*/

    @PostMapping("/createbook")
    public int createBook(@RequestBody Book book) {

        bookService.saveBook(book);
        return book.getId();
    }

    @DeleteMapping("/deletebook/{idBook}")
    public void deleteBook(@PathVariable("idBook") int idBook) {
        bookService.deleteBook(idBook);
    }

    @PutMapping("/updatebook")
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }


}
