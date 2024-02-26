package com.apps.todoapp.controller;

import com.apps.todoapp.entity.Todo;
import com.apps.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping()
//@CrossOrigin(origins = "http://localhost:9001")
@Controller
@RequestMapping("/todoapp")
public class TodoController {
    private TodoService todoService;

//quick and dirty: inject employee dao (use constructor injection)

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public String home() {
        return "index";
    }


    @GetMapping("/todos")
    public ModelAndView getAllTodos() {
        ModelAndView modelAndView = new ModelAndView();
//        try {
            List<Todo> todos = todoService.findAll();
            modelAndView.addObject("todos", todos); // Add todos to the model
            modelAndView.setViewName("index"); // Set view name to the JSP file
//        } catch (Exception e) {
//            modelAndView.setViewName("error"); // In case of error, show error page
//        }
        return modelAndView;
    }

    @PostMapping("/addTodo")
    @ResponseBody
    public Todo addTodo(@RequestParam("title") String title) {
        Todo todo=new Todo();
        todo.setId(0);
        todo.setCompleted(false);
        todo.setTitle(title);
        Todo newTodo = todoService.save(todo);
        return newTodo;
    }
    @PostMapping("/addTodoTest")
    public Todo addTodoTest(@RequestBody Todo todo) {
        todoService.save(todo);
        return todo;
    }
    @PostMapping("/deleteTodo")
    @ResponseBody
    public String deleteTodo(@RequestParam("todoId") int id) {
        todoService.deleteById(id);
        return "Todo deleted successfully";
    }

    @PostMapping("/deleteTodos")
    @ResponseBody
    public String deleteTodos(@RequestBody Map<String, List<Integer>> requestBody) {
        List<Integer> todoIds = requestBody.get("todoIds");
        todoService.deleteTodos(todoIds);
        return "Selected todos deleted successfully";
    }

    @PostMapping("/editTodo")
    @ResponseBody
    public String editTodo(@RequestParam("id") int id,
                           @RequestParam("title") String title,
                           @RequestParam("completed") boolean completed) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            todo.setTitle(title);
            todo.setCompleted(completed);
            todoService.save(todo);
            return "Todo edited successfully";
        } else {
            return "Todo not found";
        }
    }

}
