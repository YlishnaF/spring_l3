package com.fadeeva.spring_l3.api;

import lombok.Data;

@Data
public class IssueRequest {
    private long readerId;
    private long bookId;

}
