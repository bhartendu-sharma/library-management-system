package com.apps.todoapp.service;

import com.apps.todoapp.dao.TodoDao;
import com.apps.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoDao todoDao;

    @Autowired
    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public List<Todo> findAll() {
        return todoDao.findAll();
    }

    @Override
    public Todo findById(int id) {
        return todoDao.findById(id);
    }

    @Transactional
    @Override
    public Todo save(Todo todo) {
        return todoDao.save(todo);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        todoDao.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteTodos(List<Integer> todoIds) {
       for (int id:todoIds){
           deleteById(id);
       }
    }
}
