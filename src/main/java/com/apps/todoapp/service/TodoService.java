package com.apps.todoapp.service;

import com.apps.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(int id);
    Todo save(Todo todo);
    void deleteById(int id);
    void deleteTodos(List<Integer> todoIds);
}
