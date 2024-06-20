package com.fadeeva.spring_l3.repository;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.BookEntity;
import com.fadeeva.spring_l3.model.Reader;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findById(long id);
//    private final List<Reader> readers;
//
//    public List<Reader> getReaders() {
//        return readers;
//    }
//
//    public ReaderRepository(List<Reader> readers) {
//        this.readers = readers;
//    }
//
//    @PostConstruct
//    public void generateData() {
//        readers.addAll(List.of(
//                new Reader("Игорь"),
//                new Reader("Петр"),
//                new Reader("Иван")
//        ));
//    }
//
//    public Reader getReaderById(long id) {
//        return readers.stream().filter(b -> Objects.equals(b.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//
//    public Reader addReader(Reader reader) {
//        readers.add(reader);
//        return reader;
//    }
//
//    public Reader removeReader(Reader reader) {
//        readers.remove(reader);
//        return reader;
//    }
}
