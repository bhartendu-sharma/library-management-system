package com.apps.todoapp.dao;

import com.apps.todoapp.entity.Todo;

import java.util.List;

public interface TodoDao {
    List<Todo> findAll();
    Todo findById(int id);
    Todo save(Todo todo);
    void deleteById(int id);

}
