package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getBookById(long id) {
        return checkBookExists(id);
    }

    public Book addBook(String name) {
        return bookRepository.addBook(new Book(name));
    }
    public Book deleteBook(long id) {
        return bookRepository.removeBook(checkBookExists(id));
    }


    private Book checkBookExists(long id) {
        Book book = bookRepository.getBookById(id);
        if (book == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + id + "\"");
        }
        return book;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getBooks();
    }

}
