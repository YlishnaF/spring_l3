package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.model.Reader;
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
        return readerRepository.findById(id);
    }

    public Reader addReader(String name) {
        return readerRepository.save(new Reader(name));
    }
    public Reader deleteReader(long id) {
        Reader entity = getReaderById(id);
        readerRepository.delete(entity);
        return entity;
    }


//    private Reader checkBookExists(long id) {
//        Reader reader = readerRepository.getReaderById(id);
//        if (reader == null) {
//            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + id + "\"");
//        }
//        return reader;
//    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

}
