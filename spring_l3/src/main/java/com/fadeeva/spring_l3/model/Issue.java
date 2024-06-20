package com.fadeeva.spring_l3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="issues")
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private long bookId;
    @Column(nullable = false)
    private  long readerId;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column
    public LocalDateTime returned;

    public Issue(long bookId, long readerId){
        this.bookId = bookId;
        this.readerId=readerId;
        this.timestamp = LocalDateTime.now();
        this.returned = null;
    }
}
