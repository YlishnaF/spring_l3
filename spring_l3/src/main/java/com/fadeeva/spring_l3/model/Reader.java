package com.fadeeva.spring_l3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Reader {
    private final long id;
    private final String name;
    public static long sequence = 1L;

    public Reader(String name) {
        this(sequence++, name);
    }
}