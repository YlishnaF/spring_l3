package com.fadeeva.spring_l3.repository;

import com.fadeeva.spring_l3.model.Book;
import com.fadeeva.spring_l3.model.Issue;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {
    public IssueRepository(List<Issue> issues) {
        this.issues = issues;
    }

    private final List<Issue> issues;

    public void save(Issue issue){
        issues.add(issue);
    }

    public Issue getIssueById(long id){
        return issues.stream().filter(i ->Objects.equals(id, i.getId())).findFirst().orElse(null);
    }

    public boolean isBookOnHand(long id){
        if(issues.stream().anyMatch(x -> Objects.equals(x.getReaderId(), id))){
            return issues.stream().anyMatch(x->Objects.equals(x.getReturned(), null));
        }
        return false;
    }

    public List<Issue> getIssues() {
        return issues;
    }

}
