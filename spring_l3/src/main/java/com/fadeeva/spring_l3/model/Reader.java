package com.fadeeva.spring_l3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="readers")
@Data
@NoArgsConstructor

public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    public Reader(String name) {
        this.name=name;
    }
}