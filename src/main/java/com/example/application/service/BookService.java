package com.example.application.service;

import com.example.application.model.Book;
import com.example.application.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
