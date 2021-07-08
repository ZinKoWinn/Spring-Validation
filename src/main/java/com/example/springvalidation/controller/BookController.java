package com.example.springvalidation.controller;

import com.example.springvalidation.ds.Author;
import com.example.springvalidation.ds.Book;
import com.example.springvalidation.services.AuthorService;
import com.example.springvalidation.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String create(Model model) {
        model.addAttribute("books", new Book());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "bookForm";
    }

    @PostMapping("/books")
    public String process(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm";
        }
        Author author = authorService.findAuthor(book.getAuthor().getId());
        book.setAuthor(author);
        bookService.save(book);
        return "redirect:/allBooks";

    }

    @GetMapping("/allBooks")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
