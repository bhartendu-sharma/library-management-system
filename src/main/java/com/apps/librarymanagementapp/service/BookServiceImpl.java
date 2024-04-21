package com.apps.librarymanagementapp.service;

import com.apps.librarymanagementapp.entity.Book;
import com.apps.librarymanagementapp.entity.User;
import com.apps.librarymanagementapp.repository.BookRepository;
import com.apps.librarymanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null);

//NL:         The userRepository.findById(userId) method typically returns an Optional<T> type,
//        where T is the type of entity managed by the repository.

//     The .orElse(null) part is used to handle the case where the User object is not found
//        in the repository. If the user is not found, the .orElse(null) ensures that null is
//        returned instead of an empty Optional.

//        So, the purpose of orElse(null) is to provide a default value (in this case, null)
//        to be used when the object is not found. It's a way of gracefully handling the
//        absence of a result.

//        However, depending on the context and requirements of your application,
//        we might choose different strategies for handling the absence of a User object.
//        we could throw an exception, return a default user, or handle it in some other way
//        that makes sense for your use case. Using .orElse(null) is just one possible approach.

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }

    @Override
    public Book returnBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }

    @Override
    public List<Book> findBooksByUserId(Long userId) {
        return bookRepository.findByBorrowedBy_Id(userId);
    }
}