package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.model.BookEntity;
import com.fadeeva.spring_l3.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BooksRepository repository;

    public BookEntity getBookById(long id) {
        return repository.findById(id);
    }

    public List<BookEntity> getAllBooks() {
        return repository.findAll();
    }

    public BookEntity addBook(String name) {
        return repository.save(new BookEntity(name));
    }

    public BookEntity deleteBook(long id) {
        BookEntity entity = getBookById(id);
        repository.deleteById(id);
        return entity;
    }
}
