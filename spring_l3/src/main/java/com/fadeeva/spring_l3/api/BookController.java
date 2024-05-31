package com.fadeeva.spring_l3.api;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.Issue;
import com.fadeeva.spring_l3.repository.BookRepository;
import com.fadeeva.spring_l3.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<Book>getBookById(@PathVariable long id){
        log.info("Получен запрос поиск книги: id = {}", id);
        final Book book;
        try {
            book = service.getBookById(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(book);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable long id){
        log.info("Получен запрос на удаление книги: id = {}", id);
        final Book book;
        try {
            book = service.deleteBook(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PostMapping
    public Book addBook(@RequestBody String name){
        log.info("Получен запрос на добавление книги: name = {}", name);
        return service.addBook(name);
    }

}
