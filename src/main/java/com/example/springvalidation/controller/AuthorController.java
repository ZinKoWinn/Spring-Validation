package com.example.springvalidation.controller;

import com.example.springvalidation.ds.Author;
import com.example.springvalidation.services.AuthorService;
import com.example.springvalidation.validator.AuthorValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public String authorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @PostMapping("/author")
    public String processAuthor(@Valid Author author, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "authorForm";
        }
        authorService.save(author);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/authors";
    }

    @GetMapping("authors")
    public String showAll(Model model) {
        model.addAttribute("authors", authorService.findAllAuthor());
        model.addAttribute("success", model.containsAttribute("success"));
        return "authors";
    }

    //  @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AuthorValidator());
    }
}
