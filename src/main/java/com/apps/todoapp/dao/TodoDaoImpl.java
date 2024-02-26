package com.apps.todoapp.dao;

import com.apps.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao {

//    define field for entityManager
    private EntityManager entityManager;

//    set constructor injection

    @Autowired
    public TodoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("FROM todo_dtl__entity_1", Todo.class)
                .getResultList();
    }

    @Override
    public Todo findById(int id) {
        return entityManager.find(Todo.class, id);
    }

    @Override
    public Todo save(Todo todo) {
        if (todo.getId() == 0) {
//            todo.setId(0L);
            entityManager.persist(todo);
        } else {
            todo = entityManager.merge(todo);
        }
        return todo;
    }

    @Override
    public void deleteById(int id) {
        Todo todoToDelete = entityManager.find(Todo.class, id);
        if (todoToDelete != null) {
            entityManager.remove(todoToDelete);
        }
    }


}
