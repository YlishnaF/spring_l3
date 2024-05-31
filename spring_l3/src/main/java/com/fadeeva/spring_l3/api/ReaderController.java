package com.fadeeva.spring_l3.api;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.Issue;
import com.fadeeva.spring_l3.model.Reader;
import com.fadeeva.spring_l3.repository.BookRepository;
import com.fadeeva.spring_l3.service.BookService;
import com.fadeeva.spring_l3.service.ReaderService;
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
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderService service;

    @GetMapping("/{id}")
    public ResponseEntity<Reader>getReaderById(@PathVariable long id){
        log.info("Получен запрос поиск читателя: id = {}", id);
        final Reader reader;
        try {
            reader = service.getReaderById(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> deleteBookById(@PathVariable long id){
        log.info("Получен запрос на удаление читателя: id = {}", id);
        final Reader reader;
        try {
            reader = service.deleteReader(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }

    @PostMapping
    public Reader addBook(@RequestBody String name){
        log.info("Получен запрос на добавление читателя: name = {}", name);
        return service.addReader(name);
    }

}
