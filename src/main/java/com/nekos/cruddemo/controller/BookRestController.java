package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Book;
import com.nekos.cruddemo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable int id){
        return bookService.findById(id);
    }

    @PostMapping("/books")
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

}
