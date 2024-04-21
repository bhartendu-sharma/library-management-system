package com.apps.librarymanagementapp.controller;

import com.apps.librarymanagementapp.dto.BookDTO;
import com.apps.librarymanagementapp.entity.Book;
import com.apps.librarymanagementapp.mapper.BookMapper;
import com.apps.librarymanagementapp.service.BookService;
import com.apps.librarymanagementapp.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library-management/api/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookServiceImpl bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDto) {
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        bookMapper.updateBookFromDto(bookDto, existingBook);
        Book updatedBook = bookService.save(existingBook);
        return ResponseEntity.ok(bookMapper.toDto(updatedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Or ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() based on your error handling strategy
        }
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<?> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        return borrowedBook != null ? ResponseEntity.ok(borrowedBook) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<?> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        return returnedBook != null ? ResponseEntity.ok(returnedBook) : ResponseEntity.badRequest().build();
    }
    @GetMapping("/users/{userId}/books")
    public ResponseEntity<List<Book>> getBooksByUser(@PathVariable Long userId) {
        List<Book> books = bookService.findBooksByUserId(userId);
        return ResponseEntity.ok(books);
    }
}

