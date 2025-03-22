package com.sonal.todos.repository;

import com.sonal.todos.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}