package com.fadeeva.spring_l3.repository;

import com.fadeeva.spring_l3.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {
    private final List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public BookRepository(List<Book> books) {
        this.books = books;
    }

    @PostConstruct
    public void generateData() {
        books.addAll(List.of(
                new Book("война и мир"),
                new Book("этот безумный мир"),
                new Book("девять")
        ));
    }

    public Book getBookById(long id){
        return books.stream().filter(b-> Objects.equals(b.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public Book removeBook(Book book){
        books.remove(book);
        return book;
    }
}
