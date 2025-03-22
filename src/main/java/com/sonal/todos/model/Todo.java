package com.sonal.todos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "todos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    private String id;
    private String title;
    private String description;
    private String priority;
    private boolean complete;
}