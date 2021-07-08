package com.example.springvalidation.services;

import com.example.springvalidation.ds.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);
    Book findBookById(int id);
    List<Book> findAll();
    List<Book> finBookByAuthorName(String name);
}