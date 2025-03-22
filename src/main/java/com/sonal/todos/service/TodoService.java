package com.sonal.todos.service;

import com.sonal.todos.dto.TodoDTO;
import com.sonal.todos.mapper.TodoMapper;
import com.sonal.todos.model.Todo;
import com.sonal.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service 
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoMapper mapper;

    @Cacheable(value = "todos")
    public List<TodoDTO> getAllTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "todo", key = "#id")
    public Optional<TodoDTO> getTodoById(String id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @CacheEvict(value = "todos", allEntries = true)
    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = mapper.toEntity(todoDTO);
        Todo savedTodo = repository.save(todo);
        return mapper.toDTO(savedTodo);
    }

    @Caching(evict = {
        @CacheEvict(value = "todos", allEntries = true),
        @CacheEvict(value = "todo", key = "#id")
    })
    public TodoDTO updateTodo(String id, TodoDTO updatedTodoDTO) {
        return repository.findById(id).map(existingTodo -> {
            // Use the mapper to update the entity, handling nulls.
            mapper.updateEntity(updatedTodoDTO, existingTodo);
            existingTodo.setId(id);
            Todo updatedTodo = repository.save(existingTodo);
            return mapper.toDTO(updatedTodo);
        }).orElse(null);
    }

    @Caching(evict = {
            @CacheEvict(value = "todos", allEntries = true),
            @CacheEvict(value = "todo", key = "#id")
    })
    public void deleteTodoById(String id) {
        repository.deleteById(id);
    }
}
