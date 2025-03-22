package com.sonal.todos.controller;

import com.sonal.todos.dto.TodoDTO;
import com.sonal.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<TodoDTO> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Optional<TodoDTO> getTodoById(@PathVariable String id) {
        return service.getTodoById(id);
    }

    @PostMapping
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO) {
        return service.createTodo(todoDTO);
    }

    @PutMapping("/{id}")
    public TodoDTO updateTodo(@PathVariable String id, @RequestBody TodoDTO todoDTO) {
        return service.updateTodo(id, todoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable String id) {
        service.deleteTodoById(id);
    }
}
