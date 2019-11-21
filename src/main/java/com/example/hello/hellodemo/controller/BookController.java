package com.example.hello.hellodemo.controller;

import com.example.hello.hellodemo.exception.NotFoundException;
import com.example.hello.hellodemo.model.Book;
import com.example.hello.hellodemo.repository.BookRepository;
import com.example.hello.hellodemo.utils.EmptyUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.logging.Logger;


/**
 * Created by sunyuqing on 2019/9/20.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private static Logger logger = Logger.getLogger(BookController.class.getName());

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public @ResponseBody
    String insertBook(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam long publishDate,
            @RequestParam float price) {

        bookRepository.insertBook(title, content, publishDate, price);
        logger.info(String.format("Saved %s successfully", title));
        return "Saved";

    }

    @GetMapping
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/search")
    public @ResponseBody
    Iterable<Book> searchBooks(@RequestParam String query) {
        return bookRepository.search(query);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Book getBookById(@RequestParam int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = null;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    @GetMapping(path = "/{title}")
    public @ResponseBody
    Iterable<Book> getBooksByName(@PathVariable String title) {
        return bookRepository.findAllByTitle(title);
    }

    @DeleteMapping
    public @ResponseBody
    String deleteBookById(@RequestParam int id) throws NotFoundException {
        if (!bookRepository.existsById(id))
            throw new NotFoundException("The book with id " + id + " is not exist.");
        bookRepository.deleteById(id);
        return "success";
    }

    @PatchMapping("/{id}")
    public @ResponseBody
    Book updateBookById(@PathVariable int id,
                        @RequestParam(required = false) String title,
                        @RequestParam(required = false) String content,
                        @RequestParam(required = false) long publishDate,
                        @RequestParam(required = false, defaultValue = "-1") float price)
            throws NotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = null;
        if (!optionalBook.isPresent())
            throw new NotFoundException("The book with id " + id + " is not exist.");
        book = optionalBook.get();
        if (!EmptyUtils.isEmpty(title))
            book.setTitle(title);
        if (!EmptyUtils.isEmpty(content))
            book.setContent(content);
        if (EmptyUtils.isEmpty(publishDate))
            book.setPublicationDate(publishDate);
        if (price >= 0)
            book.setPrice(price);
        bookRepository.save(book);
        return book;
    }

}
