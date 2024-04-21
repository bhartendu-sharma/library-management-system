package com.apps.librarymanagementapp.service;

import com.apps.librarymanagementapp.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    Book borrowBook(Long bookId, Long userId);
    Book returnBook(Long bookId);
    List<Book> findBooksByUserId(Long userId);
}
