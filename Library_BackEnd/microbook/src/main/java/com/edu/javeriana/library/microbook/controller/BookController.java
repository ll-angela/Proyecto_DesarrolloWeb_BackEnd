package com.edu.javeriana.library.microbook.controller;

import com.edu.javeriana.library.microbook.domain.Book;
import com.edu.javeriana.library.microbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/booklist")
    public List<Book> findAllBooks() {

        return bookService.findAllBooks();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/bookspaged")
    public ResponseEntity<Page<Book>> pages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc) {
        Page<Book> books = bookService.paged(PageRequest.of(page, size, Sort.by(order)));
        if (!asc)
            books = bookService.paged(PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/book/{idBook}")
    private Book getBooks(@PathVariable("idBook") Integer idBook)
    {
        return bookService.getBookById(idBook);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/bookname/{bookName}")
    private List<Book> findByName(@PathVariable("bookName") String bookName) {
        return bookService.getBookByName(bookName);
    }

    /*@GetMapping("/bookeditorial/{editorialName}")
    private List<Book> findByEditorial(@PathVariable("editorialName") String editorialName) {
        return bookService.getBooksByEditorial(editorialName);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createbook")
    public int createBook(@RequestBody Book book) {

        bookService.saveBook(book);
        return book.getId();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deletebook/{idBook}")
    public void deleteBook(@PathVariable("idBook") int idBook) {
        bookService.deleteBook(idBook);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updatebook")
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }


}
