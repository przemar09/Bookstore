package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private LocalDateTime added;
    private LocalDateTime rented;
    private LocalDateTime released;
    private String coverUrl;

    public Book() {}

    public Book(String title, String author, String isbn, LocalDateTime added, String coverUrl) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.added = added;
        this.coverUrl = coverUrl;
    }
}
