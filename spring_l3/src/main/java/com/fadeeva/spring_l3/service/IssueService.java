package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.api.IssueRequest;
import com.fadeeva.spring_l3.model.Issue;
import com.fadeeva.spring_l3.repository.BookRepository;
import com.fadeeva.spring_l3.repository.IssueRepository;
import com.fadeeva.spring_l3.repository.ReaderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Data
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public List<Issue> getIssueRepository() {
        return issueRepository.getIssues();
    }

    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        if(issueRepository.isBookOnHand(request.getReaderId())){
            throw new IllegalArgumentException("Есть книга на руках, отказано в выдаче!");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue closeIssue(long id) {
        Issue closedIssue = issueRepository.getIssueById(id);
        if (closedIssue == null) {
            throw new NoSuchElementException("Не найдена запись о выдаче с идентификатором \"" + id + "\"");
        }
        issueRepository.getIssueById(id).setReturned(LocalDateTime.now());
        return closedIssue;

    }

    public Issue getIssue(long id) {
        Issue issue = issueRepository.getIssueById(id);
        if (issue == null) {
            throw new NoSuchElementException("Не найдена запись о выдаче с идентификатором \"" + id + "\"");
        }
        return issue;

    }
}
