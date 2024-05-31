package com.fadeeva.spring_l3.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private final long id;
    private final long bookId;
    private final long readerId;
    private final LocalDateTime timestamp;
    public LocalDateTime returned;
    public static long sequence = 1L;

    public Issue(long bookId, long readerId){
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId=readerId;
        this.timestamp = LocalDateTime.now();
        this.returned = null;
    }
}
