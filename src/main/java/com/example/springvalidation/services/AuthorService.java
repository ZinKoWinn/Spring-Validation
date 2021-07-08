package com.example.springvalidation.services;

import com.example.springvalidation.ds.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    Author save(Author author);
    Author findAuthor(int id);
    List<Author> findAllAuthor();
}
