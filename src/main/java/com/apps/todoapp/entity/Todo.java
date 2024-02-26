package com.apps.todoapp.entity;

import javax.persistence.*;

@Entity(name = "todo_dtl__entity_1")
@Table(name = "todo_dtl__tbl_1")
public class Todo {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_dtl__tbl_1_sequence_generator")
//    @SequenceGenerator(name = "todo_dtl__tbl_1_sequence_generator", sequenceName = "todo_dtl__tbl_1_seq", allocationSize = 1)
//    private Long id;

    private String title;
    private boolean completed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}