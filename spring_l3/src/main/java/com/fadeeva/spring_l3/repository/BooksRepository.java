package com.fadeeva.spring_l3.repository;

import com.fadeeva.spring_l3.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findById(long id);
//    BookEntity aveAndFlush(BookEntity entity);

}
