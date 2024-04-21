package com.apps.librarymanagementapp.repository;

import com.apps.librarymanagementapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByBorrowedBy_Id(Long userId);

}
