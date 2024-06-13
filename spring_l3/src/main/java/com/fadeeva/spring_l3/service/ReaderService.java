package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.Reader;
import com.fadeeva.spring_l3.repository.BookRepository;
import com.fadeeva.spring_l3.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public Reader getReaderById(long id) {
        return checkBookExists(id);
    }

    public Reader addReader(String name) {
        return readerRepository.addReader(new Reader(name));
    }
    public Reader deleteReader(long id) {
        return readerRepository.removeReader(checkBookExists(id));
    }


    private Reader checkBookExists(long id) {
        Reader reader = readerRepository.getReaderById(id);
        if (reader == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + id + "\"");
        }
        return reader;
    }

    public List<Reader> getAllReaders() {
        return readerRepository.getReaders();
    }

}
