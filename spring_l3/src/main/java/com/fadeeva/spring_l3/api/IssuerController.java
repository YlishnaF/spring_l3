package com.fadeeva.spring_l3.api;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.Issue;
import com.fadeeva.spring_l3.model.Reader;
import com.fadeeva.spring_l3.repository.BookRepository;
import com.fadeeva.spring_l3.repository.ReaderRepository;
import com.fadeeva.spring_l3.service.IssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/issue")
public class IssuerController {
    @Autowired
    private IssueService service;

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
        final Issue issue;
        try {
            issue = service.issue(request);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Issue> closeIssueBook(@PathVariable long id) {
        log.info("Получен запрос на возврат: id = {}", id);
        final Issue issue;
        try {
            issue = service.closeIssue(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueBook(@PathVariable long id) {
        log.info("Получен запрос на информацию о выдаче: id = {}", id);
        final Issue issue;
        try {
            issue = service.getIssue(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }
    @GetMapping("/issues")
    public String issues(Model model){
        List<Issue> issues = service.getIssueRepository();
        ReaderRepository repReaders = service.getReaderRepository();
        BookRepository repBooks = service.getBookRepository();
        model.addAttribute("issues", issues);
        model.addAttribute("repReaders", repReaders);
        model.addAttribute("repBooks", repBooks);
        return "issues";
    }
}
