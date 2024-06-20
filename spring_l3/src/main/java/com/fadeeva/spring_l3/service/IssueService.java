package com.fadeeva.spring_l3.service;

import com.fadeeva.spring_l3.api.IssueRequest;
import com.fadeeva.spring_l3.model.Issue;
import com.fadeeva.spring_l3.repository.BooksRepository;
import com.fadeeva.spring_l3.repository.IssueRepository;
import com.fadeeva.spring_l3.repository.ReaderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class IssueService {
    private final BooksRepository bookRepository;
    private final ReaderRepository readerRepository;

    public List<Issue> getIssueRepository() {

        return issueRepository.findAll();
    }

    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.findById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.findById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        if(isBookOnHand(request.getReaderId())){
            throw new IllegalArgumentException("Есть книга на руках, отказано в выдаче!");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }
    public boolean isBookOnHand(long id){
        if(issueRepository.findAll().stream().anyMatch(x -> Objects.equals(x.getReaderId(), id))){
            return issueRepository.findAll().stream().anyMatch(x->Objects.equals(x.getReturned(), null));
        }
        return false;
    }

    public Issue closeIssue(long id) {
        Optional<Issue> closedIssue=issueRepository.findById(id);
        closedIssue.ifPresent(issue -> issue.setReturned(LocalDateTime.now()));
        return closedIssue.orElseGet(closedIssue::get);
    }

    public Issue getIssue(long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        return issue.orElseGet(issue::get);
    }
}
