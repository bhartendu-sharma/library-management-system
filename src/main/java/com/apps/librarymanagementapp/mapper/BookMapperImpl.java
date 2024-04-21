package com.apps.librarymanagementapp.mapper;

import com.apps.librarymanagementapp.dto.BookDTO;
import com.apps.librarymanagementapp.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public void updateBookFromDto(BookDTO bookDto, Book book) {
        // Implement the mapping logic from BookDTO to Book entity manually
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        // Map other fields as needed
    }

    @Override
    public BookDTO toDto(Book book) {
        // Implement the mapping logic from Book entity to BookDTO manually
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        // Map other fields as needed
        return bookDTO;
    }
}
