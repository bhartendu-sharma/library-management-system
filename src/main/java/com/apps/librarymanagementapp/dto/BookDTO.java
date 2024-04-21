package com.apps.librarymanagementapp.dto;

import com.apps.librarymanagementapp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    private Long borrowedById; // Assuming you want to include the ID of the user who borrowed the book

    // You can include other fields or methods as needed

    public BookDTO() {
    }

    // Constructor to create DTO from entity
    public BookDTO(Long id, String title, String author, boolean borrowed, User borrowedBy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
        if (borrowedBy != null) {
            this.borrowedById = borrowedBy.getId();
        }
    }
}
