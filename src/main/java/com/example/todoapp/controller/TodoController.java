package com.example.todoapp.controller;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    repo repo;

    @GetMapping
    private List<TodoItem> allTodos() {
        return repo.findAll();
    }

    @PostMapping
    private List<TodoItem> createTodo(@RequestBody TodoItem item) {
        repo.save(item);
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    private List<TodoItem> deleteTodo(@PathVariable int id) {
        repo.deleteById(id);
        return repo.findAll();
    }

    @GetMapping("/{id}")
    private TodoItem getItemById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }
}
